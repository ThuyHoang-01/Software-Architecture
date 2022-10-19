using System;
using System.Messaging;
using System.Windows.Forms;
using QuanLyBenhNhan;

namespace SendBenhNhan
{
    public partial class Form1 : Form
    {
        MessageQueue queue = null;
        public Form1()
        {
            InitializeComponent();
            init();
        }
        private void init()
        {

            string path = @".\private$\phongkham";
            //string path = @"hbmnl\private$\phongkehoach";
            if (MessageQueue.Exists(path))
            {
                queue = new MessageQueue(path, QueueAccessMode.Send);
            }
            else
                queue = MessageQueue.Create(path, true);
            queue.Label = "queue cho phong kham benh nhan";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            long id =long.Parse(textBox1.Text);
            string soCMND = textBox2.Text;
            string hovaTen = textBox3.Text;
            string diaChi = textBox4.Text;
          
            BenhNhan bn = new BenhNhan(id,soCMND,hovaTen,diaChi);
            MessageQueueTransaction transaction = new MessageQueueTransaction();
            transaction.Begin();
            queue.Send(bn, transaction);
            transaction.Commit();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
