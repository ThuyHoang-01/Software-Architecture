using QuanLySanPham;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Messaging;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GiuaKy_Sender
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
            string path = @".\private$\phongkehoach";
            //string path = @"hbmnl\private$\phongkehoach";
            if (MessageQueue.Exists(path))
            {
                queue = new MessageQueue(path, QueueAccessMode.Send);
            }
            else
                queue = MessageQueue.Create(path, true);
                queue.Label = "queue cho phong ke hoach";
        }
        private void label1_Click(object sender, EventArgs e)
        {

        }
        private void label2_Click(object sender, EventArgs e)
        {

        }
        private void label3_Click(object sender, EventArgs e)
        {

        }
        private void label4_Click(object sender, EventArgs e)
        {

        }
        
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            long id = long.Parse(textBox1.Text);
            string tenSP = textBox2.Text;
            string soLuong = textBox3.Text;
            string loai1 = textBox4.Text;
            string diaChi = richTextBox1.Text;

            SanPham sp = new SanPham(id, tenSP, soLuong, loai1, diaChi);
           // MessageBox.Show("sp" + sp);
            MessageQueueTransaction transaction = new MessageQueueTransaction();
            transaction.Begin();
            queue.Send(sp, transaction);
            transaction.Commit();
        }
    }
}
