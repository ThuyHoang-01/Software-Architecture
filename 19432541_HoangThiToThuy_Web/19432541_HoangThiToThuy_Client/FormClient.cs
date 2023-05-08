using _19432541_HoangThiToThuy_Client.tothuy;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _19432541_HoangThiToThuy_Client
{
    public partial class FormClient : Form
    {
        public static tothuy.WebService1SoapClient b = new tothuy.WebService1SoapClient();
        public FormClient()
        {
            InitializeComponent();
            LoadAllStudentListBox();
            CreateColums();
            LoadAllStudentListView();
            ClearText();
        }

        private void ClearText()
        {
            txtMa.Text = "";
            txtTen.Text = "";
            txtLop.Text = "";
            txtTuoi.Text = "";
            txtKhoa.Text = "";
        }

        private void LoadAllStudentListView()
        {
            if (b.listDS() != null)
            {
                foreach (var item in b.listDS())
                {
                    ListViewItem stdItem = new ListViewItem();
                    stdItem.Text = item.ma;
                    stdItem.SubItems.Add(item.ten);
                    stdItem.SubItems.Add(item.lop);
                    stdItem.SubItems.Add(item.khoa);
                    stdItem.SubItems.Add(item.tuoi + "");
                    listView1.Items.Add(stdItem);

                }
            }
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

        private void LoadAllStudentListBox()
        {
            if (b.listDS() != null)
            {
                foreach (var item in b.listDS())
                {
                    listBox1.Items.Add(item.ma);

                }
            }
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string ma = txtMa.Text;
            string ten = txtTen.Text;
            string lop = txtLop.Text;
            string khoa = txtTuoi.Text;
            int tuoi = int.Parse(txtTuoi.Text);

            string result = b.add(ma, ten, lop, khoa, tuoi);

            MessageBox.Show("" + result);
            listBox1.Items.Clear();
            listView1.Items.Clear();
            LoadAllStudentListBox();
            LoadAllStudentListView();
        }

        private void btnTim_Click(object sender, EventArgs e)
        {
            sinhVien sv = b.ds_id(txtTim.Text);
            if (sv != null)
            {
                listView1.Items.Clear();
                ListViewItem stdItem = new ListViewItem();
                stdItem.Text = sv.ma;
                stdItem.SubItems.Add(sv.ten);
                stdItem.SubItems.Add(sv.lop);
                stdItem.SubItems.Add(sv.khoa);
                stdItem.SubItems.Add(sv.tuoi + "");
                listView1.Items.Add(stdItem);
                txtTim.Text = "";
            }
            else
            {
                MessageBox.Show("Không tìm thấy sinh viên", "Thông báo");
            }

        }
        //xl
        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
           
            if (listView1.SelectedItems.Count > 0)
            {
                
                ShowDetailStudent(b.ds_id(listView1.SelectedItems[0].Text));

            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string id = null;
            if (listBox1.SelectedItems.Count > 0)
            {
                id = listBox1.SelectedItem.ToString();
            }
            else if (listView1.SelectedItems.Count > 0)
            {
                id = listView1.SelectedItems[0].Text;
            }
            if (id != null)
            {
                if (b.xoaThanhVien(id))
                {
                    listView1.Items.Clear();
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
            sinhVien student = null;
            if (listBox1.SelectedItems.Count > 0)
            {
                student = b.ds_id(listBox1.SelectedItem.ToString());
            }
            else if (listView1.SelectedItems.Count > 0)
            {
                student = b.ds_id(listView1.SelectedItems[0].Text);
            }
            if (student != null)
            {
                b.UpdateStudent(txtMa.Text, txtTen.Text, txtLop.Text, txtKhoa.Text, Convert.ToUInt16(txtTuoi.Text));
                button3_Click(sender, e);

                MessageBox.Show("Cập sinh viên thành công", "Thông báo");
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (listBox1.SelectedItems.Count > 0)
            {

                ShowDetailStudent(b.ds_id(listBox1.SelectedItem.ToString()));

            }
        }
        private void ShowDetailStudent(sinhVien sv)
        {
            txtMa.Text = sv.ma;
            txtTen.Text = sv.ten;
            txtLop.Text = sv.lop;
            txtKhoa.Text = sv.khoa;
            txtTuoi.Text = Convert.ToString(sv.tuoi);

        }

        private void button3_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();
            listBox1.Items.Clear();
            LoadAllStudentListView();
            LoadAllStudentListBox();
            
        }
    }
}
