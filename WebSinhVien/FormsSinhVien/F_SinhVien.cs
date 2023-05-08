using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using FormsSinhVien.tothuy;

namespace FormsSinhVien
{
    public partial class F_SinhVien : Form
    {
        public static WebService1SoapClient b = new WebService1SoapClient();
        public F_SinhVien()
        {
            InitializeComponent();
            LoadAllStudentListBox();
            CreateColums();
            LoadAllStudentListView();
            ClearText();

        }

        private void LoadAllStudentListBox()
        {
       //     FormsSinhVien.tothuy.WebService1SoapClient b = new tothuy.WebService1SoapClient();
            if (b.listDS() != null)
            {
                foreach (var item in b.listDS())
                {
                    listBox1.Items.Add(item.maSV);

                }
            }
        }
        private void LoadAllStudentListView()
        {
            if (b.listDS() != null)
            {
                foreach (var item in b.listDS())
                {
                    ListViewItem stdItem = new ListViewItem();
                    stdItem.Text = item.maSV;
                    stdItem.SubItems.Add(item.fullName);
                    stdItem.SubItems.Add(item.lop);
                    stdItem.SubItems.Add(item.khoa);
                    stdItem.SubItems.Add(item.tuoi + "");
                    listBox1.Items.Add(stdItem);

                }
            }
        }
       
   


        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            string id = null;
            if (listBox1.SelectedItems.Count > 0)
            {
                id = listView1.SelectedItems.ToString();
            }
            else if (listView1.SelectedItems.Count > 0)
            {
                id = listView1.SelectedItems[0].Text;
            }
            if (id != null)
            {
                if (b.xoaThanhVien(id))
                {
                    listBox1.Items.Clear();
                    listBox1.Items.Clear();
                    LoadAllStudentListBox();
                    LoadAllStudentListView();
                    MessageBox.Show("Xóa thành công");
                }
            }
            else
            {
                MessageBox.Show("vui lòng chọn mã", "Thông báo");
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private void CreateColums()
        {

            listView1.View = View.Details;
            listView1.Columns.Add("Mã sinh viên", 100);
            listView1.Columns.Add("Tên sinh viên", 100);
            listView1.Columns.Add("Lớp", 100);
            listView1.Columns.Add("khoa", 100);
            listView1.Columns.Add("Tuổi", 100);

        }
        private void ClearText()
        {
            textBox2.Text = "";
            textBox3.Text = "";
            textBox4.Text = "";
            textBox5.Text = "";
            textBox6.Text = "";
        }

        private void button5_Click(object sender, EventArgs e)
        {
            sinhVien sv = b.ds_id(textBox1.Text);
            if (sv != null)
            {
                listView1.Items.Clear();
                ListViewItem stdItem = new ListViewItem();
                stdItem.Text = sv.maSV;
                stdItem.SubItems.Add(sv.fullName);
                stdItem.SubItems.Add(sv.lop);
                stdItem.SubItems.Add(sv.khoa);
                stdItem.SubItems.Add(sv.tuoi + "");
                listView1.Items.Add(stdItem);
                textBox1.Text = "";
            }
            else
            {
                MessageBox.Show("Không tìm thấy sinh viên", "Thông báo");
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string maSV = textBox2.Text;
            string fullName = textBox3.Text;
            string lop = textBox4.Text;
            string khoa = textBox5.Text;
            int tuoi = int.Parse(textBox6.Text);

            string result = b.add(maSV, fullName, lop, khoa, tuoi);

            MessageBox.Show("" + result);
            listBox1.Items.Clear();
            listView1.Items.Clear();
            LoadAllStudentListBox();
            LoadAllStudentListView();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();
            LoadAllStudentListView();
        }
    }
}
