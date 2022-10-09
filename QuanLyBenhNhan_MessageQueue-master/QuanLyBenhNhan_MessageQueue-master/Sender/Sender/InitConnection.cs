using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace Sender
{
    public class InitConnection
    {
        readonly String CONNECTTION_LINK = "tcp://localhost:61616";
        readonly String USER = "admin";
        readonly String PWD = "admin";
        readonly String FLAG = "gacon";

        private IConnection connection = null;

        public InitConnection()
        {
            IConnectionFactory factory = new ConnectionFactory(CONNECTTION_LINK);

            connection = factory.CreateConnection(USER, PWD);

            connection.Start();
        }

        public void sendBN(BenhNhan bn)
        {
            ISession session = connection.CreateSession(AcknowledgementMode.AutoAcknowledge);

            ActiveMQQueue active = new ActiveMQQueue(FLAG);
            IMessageProducer producer = session.CreateProducer(active);

            var json = JsonSerializer.Serialize(bn);

            IMessage message = new ActiveMQTextMessage(json);
            producer.Send(message);

            session.Close();
        }
    }
}
