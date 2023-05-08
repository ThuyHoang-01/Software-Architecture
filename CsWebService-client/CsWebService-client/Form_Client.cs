using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CsWebService_client
{
    public partial class Form_Client : Form
    {
        public Form_Client()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            CsWebService_client.CalcRef.CalculatorWebServiceSoapClient calc = new
            CalcRef.CalculatorWebServiceSoapClient();
            double a = double.Parse(textBox1.Text);
            double b = double.Parse(textBox2.Text);
            double result = calc.add(a, b);
           textBox3.Text = "" + result;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            CsWebService_client.CalcRef.CalculatorWebServiceSoapClient calc = new
            CalcRef.CalculatorWebServiceSoapClient();
            double a = double.Parse(textBox1.Text);
            double b = double.Parse(textBox2.Text);
            double result = calc.sub(a, b);
            textBox3.Text = "" + result;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            CsWebService_client.CalcRef.CalculatorWebServiceSoapClient calc = new
            CalcRef.CalculatorWebServiceSoapClient();
            double a = double.Parse(textBox1.Text);
            double b = double.Parse(textBox2.Text);
            double result = calc.product(a, b);
            textBox3.Text = "" + result;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            CsWebService_client.CalcRef.CalculatorWebServiceSoapClient calc = new
           CalcRef.CalculatorWebServiceSoapClient();
            double a = double.Parse(textBox1.Text);
            double b = double.Parse(textBox2.Text);
            double result = calc.div(a, b);
            textBox3.Text = "" + result;
        }
    }
}
