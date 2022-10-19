using System.Messaging;
using QuanLyBenhNhan;
using System.Collections.Generic;
using System.Windows.Forms;


using System.Text;
using System.IO;

namespace NhanBenhNhan
{
    public partial class Form1 : Form
    {
        private long _id;
        private List<BenhNhan> listBN = new List<BenhNhan>();
        private MessageQueue queue;
        public Form1()
        {
            InitializeComponent();
            init_queue();
        }
        void init_queue()
        {
            string path = @".\private$\phongkham";
            queue = new MessageQueue(path);
            queue.BeginReceive();
            queue.ReceiveCompleted += Queue_ReceiveCompleted;
        }
        private void Queue_ReceiveCompleted(object sender, ReceiveCompletedEventArgs e)
        {

            var msg = e.Message;
            int type = msg.BodyType;
            XmlMessageFormatter fmt = new XmlMessageFormatter(
            new System.Type[] { typeof(string), typeof(BenhNhan) }
            );
            msg.Formatter = fmt;
            var result = msg.Body;
            var t = result.GetType();
            
            if (t.Equals(typeof(BenhNhan)))
            {
                BenhNhan bn= (BenhNhan)result;
                listBN.Add(bn);
                SetText(""+bn.BenhNhanId);
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

        private void listBox1_SelectedIndexChanged(object sender, System.EventArgs e)
        {
            // tentaptin = Playlistbox.SelectedValue.ToString();
            string id = this.listBox1.SelectedItem.ToString();
            _id = long.Parse(id);
            for (int j = 0; j < listBN.Count;j++)
            {
                if (_id==listBN[j].BenhNhanId)
                {
                   // this.textBox1.Text="x";
                    this.textBox1.Text = id;
                    this.textBox2.Text = listBN[j].HovaTen;
                    this.textBox3.Text = listBN[j].SoCMND;
                    this.textBox4.Text = listBN[j].DiaChi;

                    //this.textBox1.AppendText(id);
                    //this.textBox2.AppendText(listBN[j].HovaTen);
                   // this.textBox3.AppendText(listBN[j].SoCMND);
                    //this.textBox4.AppendText(listBN[j].DiaChi);
                   

                }
            }
        }

        private void button2_Click(object sender, System.EventArgs e)
        {
            
 
            string[] m = new string[6];
            m[0] = "-----Bệnh nhân:";
            m[1] ="ID:" +this.textBox1.Text;
            m[2] ="Tên:" +this.textBox2.Text;
            m[3] = "CMND:"+this.textBox3.Text;
            m[4] = "Địa chỉ:"+this.textBox4.Text;
            m[5] = "Ghi chú:"+this.textBox5.Text;

            System.IO.File.AppendAllLines("D:\\HKI_2022-2023\\KTPM\\ThamKhao\\KT_TKPM\\" +
                "ThucHanh\\QuanLyBenhNhan\\QuanLyBenhNhan\\test.txt", m);
            
            this.textBox1.Text = "";
            this.textBox2.Text = "";
            this.textBox3.Text = "";
            this.textBox4.Text = "";
            this.textBox5.Text = "";

            int vitri=0;



        }
    }
}
