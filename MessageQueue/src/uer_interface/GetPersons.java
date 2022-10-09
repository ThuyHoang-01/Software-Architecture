package uer_interface;

import java.io.StringReader;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

import entity.Person;
import entity.Persons;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class GetPersons {
	public static void main(String[] args) throws NamingException, JMSException {
		//thiết lập môi trường cho JMS
		BasicConfigurator.configure();
		//thiết lập môi trường cho JJNDI
		Properties settings=new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		//tạo context
		Context ctx=new InitialContext(settings);
		//lookup JMS connection factory
		Object obj=ctx.lookup("ConnectionFactory");
		ConnectionFactory factory=(ConnectionFactory)obj;
		//lookup destination
		Destination destination
		=(Destination) ctx.lookup("dynamicQueues/thanthidet");
		//tạo connection
		Connection con=factory.createConnection("admin","admin");
		//nối đến MOM
		con.start();
		//tạo session
		Session session=con.createSession(
				/*transaction*/false,
				/*ACK*/Session.CLIENT_ACKNOWLEDGE
				);
		//tạo consumer
		MessageConsumer receiver = session.createConsumer(destination);
		//blocked-method for receiving message - sync
		//receiver.receive();
		//Cho receiver lắng nghe trên queue, chừng có message thì notify - async
		System.out.println("Tý was listened on queue...");
		receiver.setMessageListener(new MessageListener() {
			@Override
			//có message đến queue, phương thức này được thực thi
			public void onMessage(Message msg) {//msg là message nhận được
				try {
					if(msg instanceof TextMessage){
						TextMessage tm=(TextMessage)msg;
						String txt=tm.getText();
						
						Persons p = null;
						JAXBContext ctx= JAXBContext.newInstance(Persons.class);
						Unmarshaller ms = ctx.createUnmarshaller();
						p = (Persons) ms.unmarshal(new StringReader(txt));
						
						System.out.println("Nhận được: "+ p.getListPerson().toString());
						msg.acknowledge();//gửi tín hiệu ack
					}
					else if(msg instanceof ObjectMessage){
						ObjectMessage om=(ObjectMessage)msg;
						System.out.println(om);
					}
					//others message type....
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
