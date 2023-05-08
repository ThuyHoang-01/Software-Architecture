using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BookClient
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button_add_Click(object sender, EventArgs e)
        {
            BookClient.calcref.WebService1SoapClient b = new calcref.WebService1SoapClient();
            string id = textBox_id.Text;
            string title = textBox_title.Text;
            string author = textBox_author.Text;
            string price = textBox_price.Text;
            string pushlisher = textBox_publisher.Text;
            string result = b.add(id, title, author, price, pushlisher);
            textBox_kq.Text = "" + result;
        }

        private void button_ds_Click(object sender, EventArgs e)
        {
            BookClient.calcref.WebService1SoapClient b = new calcref.WebService1SoapClient();
            listBox.Items.Clear();
            var listSach = b.ds();
            for (int i = 0; i < listSach.Length; i++)
            {
                listBox.Items.Add("_id:" + listSach[i].id + "_title:" + listSach[i].title + "_author" + listSach[i].author + "price:" + listSach[i].price + "pub:" + listSach[i].publisher);
            }
        }

        private void button_dsID_Click(object sender, EventArgs e)
        {
            BookClient.calcref.WebService1SoapClient b = new calcref.WebService1SoapClient();
            listBox.Items.Clear();
            string id = textBox_id.Text;
            var listSach = b.ds_id(id);
            listBox.Items.Add("_id:" + listSach.id + "title:" + listSach.title + "author:" + listSach.author + "_price" + listSach.price + "_pub:" + listSach.publisher);
        
    }

        private void button_dsAuthour_Click(object sender, EventArgs e)
        {
            BookClient.calcref.WebService1SoapClient b = new calcref.WebService1SoapClient();
            listBox.Items.Clear();
            string author = textBox_author.Text;
            var listSach = b.ds_author(author);
            for (int i = 0; i < listSach.Length; i++)
            {
                listBox.Items.Add("_id:" + listSach[i].id + "_title:" + listSach[i].title + "_author:" + listSach[i].author + "_price:" + listSach[i].price + "_pub:" + listSach[i].publisher);
            }
        }

        private void button_dsPub_Click(object sender, EventArgs e)
        {
            BookClient.calcref.WebService1SoapClient b = new calcref.WebService1SoapClient();
            listBox.Items.Clear();
            string pushlisher = textBox_publisher.Text;
            var listSach = b.ds_published(pushlisher);
            for (int i = 0; i < listSach.Length; i++)
            {
                listBox.Items.Add("_id:" + listSach[i].id + "_title:" + listSach[i].title + "_author:" + listSach[i].author + "_price" + listSach[i].price + "_pub:" + listSach[i].publisher);
            }
        }

        private void button_remove_Click(object sender, EventArgs e)
        {
            BookClient.calcref.WebService1SoapClient b = new calcref.WebService1SoapClient();
            listBox.Items.Clear();
            String id = textBox_id.Text;
            var listBook = b.remove(id);
        }
    }
}
