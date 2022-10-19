using QuanLyBenhNhan;
using System;
using System.Messaging;
using System.Windows.Forms;

namespace Sender
{
    public partial class Form1 : Form
    {
        MessageQueue queue = null;
        public Form1()
        {
            InitializeComponent();
            init();
        }
        //MSMQ_Sender_Slide 14
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
        // ///

        private void label1_Click(object sender, EventArgs e)
        {

        }
        private void label2_Click(object sender, EventArgs e)
        {

        }
        private void label3_Click(object sender, EventArgs e)
        {

        }
    

    

        private void button1_Click(object sender, EventArgs e)
        {
            long id = long.Parse(textBox1.Text);
            string soCMND = textBox2.Text;
            string hovaTen = textBox3.Text;
            string diaChi = richTextBox1.Text;

            BenhNhan bn = new BenhNhan(id, soCMND, hovaTen, diaChi);
            MessageQueueTransaction transaction = new MessageQueueTransaction();
            transaction.Begin();
            queue.Send(bn, transaction);
            transaction.Commit();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
