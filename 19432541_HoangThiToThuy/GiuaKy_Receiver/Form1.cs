using QuanLySanPham;
using System;
using System.Collections.Generic;
using System.Messaging;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;


namespace GiuaKy_Receiver
{
    public partial class Form1 : Form
    {
        private long _id;
        private List<SanPham> listSP = new List<SanPham>();
        private MessageQueue queue;
        

        public Form1()
        {
            InitializeComponent();
            init_queue();
        }

        private void init_queue()
        {

            string path = @".\private$\phongkehoach";
            queue = new MessageQueue(path);
            queue.BeginReceive();
            queue.ReceiveCompleted += Queue_ReceiveCompleted;
        }

        private void Queue_ReceiveCompleted(object sender, ReceiveCompletedEventArgs e)
        {
            var msg = e.Message;
            int type = msg.BodyType;
            XmlMessageFormatter fmt = new XmlMessageFormatter(
            new System.Type[] { typeof(string), typeof(SanPham) }
            );
            msg.Formatter = fmt;
            var result = msg.Body;
            var t = result.GetType();

            if (t.Equals(typeof(SanPham)))
            {
                SanPham bn = (SanPham)result;
                listSP.Add(bn);
                SetText("" + bn.SanPhamId);
            }
            else
                SetText("" + result);
            queue.BeginReceive();//loop back
        }
        delegate void SetTextCallback(string text);
        private void SetText(string text)
        {
            // InvokeRequired required compares the thread ID of the
            // calling thread to the thread ID of the creating thread.
            // If these threads are different, it returns true.
            if (this.listBox1.InvokeRequired)
            {
                SetTextCallback callback = new SetTextCallback(SetText);
                this.Invoke(callback, new object[] { text });
            }
            else
            {
                
                this.listBox1.Items.Add(text + "\n");
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string id = this.listBox1.SelectedItem.ToString();
            long _id = long.Parse(id);
            for (int j =0; j<listSP.Count; j++)
            {
                if(_id == listSP[j].SanPhamId)
                {
                    this.textBox1.Text = id;
                    this.textBox2.Text = listSP[j].TenSP;
                    this.textBox3.Text = listSP[j].SoLuong;
                    this.textBox4.Text = listSP[j].Loai;
                    this.richTextBox1.Text = listSP[j].DiaChi;
                }
            }
        }

        private void button1_Click(object sender, System.EventArgs e)
        {


            string[] m = new string[6];
            m[0] = "-----Sản Phẩm:";
            m[1] = "ID:" + this.textBox1.Text;
            m[2] = "TênSP:" + this.textBox2.Text;
            m[3] = "Số Lượng:" + this.textBox3.Text;
            m[4] = "Loại:" + this.textBox4.Text;
            m[5] = "Địa chỉ:" + this.richTextBox1.Text;
            

            //  System.IO.File.AppendAllLines("D:\\HKI_2022-2023\\KTPM\\ThamKhao\\KT_TKPM\\" +
            //     "ThucHanh\\QuanLyBenhNhan\\QuanLyBenhNhan\\test.txt", m);

            this.textBox1.Text = "";
            this.textBox2.Text = "";
            this.textBox3.Text = "";
            this.textBox4.Text = "";
            this.richTextBox1.Text = "";
            

            //  int vitri = 0;



        }
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }
    }
}
