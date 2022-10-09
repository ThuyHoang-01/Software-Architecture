using System.Text.Json;
using System.Text.Json.Serialization;

namespace Sender
{
    public partial class Form1 : Form
    {
        InitConnection connection = null;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.ActiveControl = tbmsbn;
            connection = new InitConnection();
        }

        private void resetAllTextBox()
        {
            tbmsbn.Text = "";
            tbcmnd.Text = "";
            tbhoten.Text = "";
            tbdiachi.Text = "";

            tbmsbn.Focus();
        }

        private void btnsave_Click(object sender, EventArgs e)
        {
            String msbn = tbmsbn.Text;
            String cmnd = tbcmnd.Text;
            String hoten = tbhoten.Text;
            String diachi = tbdiachi.Text;

            BenhNhan benhNhan = new BenhNhan(msbn, cmnd, hoten, diachi);

            connection.sendBN(benhNhan);

            resetAllTextBox();
        }
    }
}