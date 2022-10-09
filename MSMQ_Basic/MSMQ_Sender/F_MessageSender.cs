using BusinessObjects;
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

namespace MSMQ_Sender
{
    public partial class F_MessageSender : Form
    {
        public F_MessageSender()
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
        private void InitializeComponent()
        {
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.btnSendText = new System.Windows.Forms.Button();
            this.btnSendObject = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // richTextBox1
            // 
            this.richTextBox1.Location = new System.Drawing.Point(12, 12);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(465, 162);
            this.richTextBox1.TabIndex = 1;
            this.richTextBox1.Text = "";
            // 
            // btnSendText
            // 
            this.btnSendText.Location = new System.Drawing.Point(63, 192);
            this.btnSendText.Name = "btnSendText";
            this.btnSendText.Size = new System.Drawing.Size(88, 32);
            this.btnSendText.TabIndex = 2;
            this.btnSendText.Text = "Send Text";
            this.btnSendText.UseVisualStyleBackColor = true;
            this.btnSendText.Click += new System.EventHandler(this.sendButton_Click);
            // 
            // btnSendObject
            // 
            this.btnSendObject.Location = new System.Drawing.Point(204, 192);
            this.btnSendObject.Name = "btnSendObject";
            this.btnSendObject.Size = new System.Drawing.Size(84, 32);
            this.btnSendObject.TabIndex = 3;
            this.btnSendObject.Text = "Send Object";
            this.btnSendObject.UseVisualStyleBackColor = true;
            this.btnSendText.Click += new System.EventHandler(this.SendObjectButton_Click);
            // 
            // F_MessageSender
            // 
            this.ClientSize = new System.Drawing.Size(489, 248);
            this.Controls.Add(this.btnSendObject);
            this.Controls.Add(this.btnSendText);
            this.Controls.Add(this.richTextBox1);
            this.Name = "F_MessageSender";
            this.ResumeLayout(false);

        }
        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
        private void sendButton_Click(object sender, EventArgs e)
        {
            string message = richTextBox1.Text;
            MessageQueueTransaction transaction = new MessageQueueTransaction();
            transaction.Begin();
            queue.Send(message, transaction);
            transaction.Commit();
        }
        private void SendObjectButton_Click(object sender, EventArgs e)
        {
            Student st = new Student(1001L, "Nguyễn văn Tèo", new DateTime(1999, 10, 15));
            MessageQueueTransaction transaction = new MessageQueueTransaction();
            transaction.Begin();
            queue.Send(st, transaction);
            transaction.Commit();
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
