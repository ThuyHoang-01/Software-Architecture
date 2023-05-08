
namespace BookClient
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.listBox = new System.Windows.Forms.ListBox();
            this.button_ds = new System.Windows.Forms.Button();
            this.button_dsID = new System.Windows.Forms.Button();
            this.button_dsAuthour = new System.Windows.Forms.Button();
            this.button_dsPub = new System.Windows.Forms.Button();
            this.button_remove = new System.Windows.Forms.Button();
            this.button_add = new System.Windows.Forms.Button();
            this.textBox_title = new System.Windows.Forms.TextBox();
            this.textBox_author = new System.Windows.Forms.TextBox();
            this.textBox_price = new System.Windows.Forms.TextBox();
            this.textBox_kq = new System.Windows.Forms.TextBox();
            this.textBox_publisher = new System.Windows.Forms.TextBox();
            this.textBox_id = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // listBox
            // 
            this.listBox.FormattingEnabled = true;
            this.listBox.ItemHeight = 16;
            this.listBox.Location = new System.Drawing.Point(522, 29);
            this.listBox.Name = "listBox";
            this.listBox.Size = new System.Drawing.Size(262, 260);
            this.listBox.TabIndex = 37;
            // 
            // button_ds
            // 
            this.button_ds.Location = new System.Drawing.Point(146, 317);
            this.button_ds.Name = "button_ds";
            this.button_ds.Size = new System.Drawing.Size(103, 41);
            this.button_ds.TabIndex = 36;
            this.button_ds.Text = "danh sách";
            this.button_ds.UseVisualStyleBackColor = true;
            this.button_ds.Click += new System.EventHandler(this.button_ds_Click);
            // 
            // button_dsID
            // 
            this.button_dsID.Location = new System.Drawing.Point(275, 317);
            this.button_dsID.Name = "button_dsID";
            this.button_dsID.Size = new System.Drawing.Size(103, 41);
            this.button_dsID.TabIndex = 35;
            this.button_dsID.Text = "tìm id";
            this.button_dsID.UseVisualStyleBackColor = true;
            this.button_dsID.Click += new System.EventHandler(this.button_dsID_Click);
            // 
            // button_dsAuthour
            // 
            this.button_dsAuthour.Location = new System.Drawing.Point(408, 317);
            this.button_dsAuthour.Name = "button_dsAuthour";
            this.button_dsAuthour.Size = new System.Drawing.Size(103, 41);
            this.button_dsAuthour.TabIndex = 34;
            this.button_dsAuthour.Text = "ds_authour";
            this.button_dsAuthour.UseVisualStyleBackColor = true;
            this.button_dsAuthour.Click += new System.EventHandler(this.button_dsAuthour_Click);
            // 
            // button_dsPub
            // 
            this.button_dsPub.Location = new System.Drawing.Point(545, 317);
            this.button_dsPub.Name = "button_dsPub";
            this.button_dsPub.Size = new System.Drawing.Size(103, 41);
            this.button_dsPub.TabIndex = 33;
            this.button_dsPub.Text = "ds_pub";
            this.button_dsPub.UseVisualStyleBackColor = true;
            this.button_dsPub.Click += new System.EventHandler(this.button_dsPub_Click);
            // 
            // button_remove
            // 
            this.button_remove.Location = new System.Drawing.Point(681, 317);
            this.button_remove.Name = "button_remove";
            this.button_remove.Size = new System.Drawing.Size(103, 41);
            this.button_remove.TabIndex = 32;
            this.button_remove.Text = "Remove";
            this.button_remove.UseVisualStyleBackColor = true;
            this.button_remove.Click += new System.EventHandler(this.button_remove_Click);
            // 
            // button_add
            // 
            this.button_add.Location = new System.Drawing.Point(16, 318);
            this.button_add.Name = "button_add";
            this.button_add.Size = new System.Drawing.Size(103, 40);
            this.button_add.TabIndex = 31;
            this.button_add.Text = "add";
            this.button_add.UseVisualStyleBackColor = true;
            this.button_add.Click += new System.EventHandler(this.button_add_Click);
            // 
            // textBox_title
            // 
            this.textBox_title.Location = new System.Drawing.Point(146, 72);
            this.textBox_title.Multiline = true;
            this.textBox_title.Name = "textBox_title";
            this.textBox_title.Size = new System.Drawing.Size(325, 28);
            this.textBox_title.TabIndex = 30;
            // 
            // textBox_author
            // 
            this.textBox_author.Location = new System.Drawing.Point(146, 116);
            this.textBox_author.Multiline = true;
            this.textBox_author.Name = "textBox_author";
            this.textBox_author.Size = new System.Drawing.Size(325, 28);
            this.textBox_author.TabIndex = 29;
            // 
            // textBox_price
            // 
            this.textBox_price.Location = new System.Drawing.Point(146, 164);
            this.textBox_price.Multiline = true;
            this.textBox_price.Name = "textBox_price";
            this.textBox_price.Size = new System.Drawing.Size(325, 28);
            this.textBox_price.TabIndex = 28;
            // 
            // textBox_kq
            // 
            this.textBox_kq.Location = new System.Drawing.Point(179, 387);
            this.textBox_kq.Multiline = true;
            this.textBox_kq.Name = "textBox_kq";
            this.textBox_kq.Size = new System.Drawing.Size(496, 35);
            this.textBox_kq.TabIndex = 27;
            // 
            // textBox_publisher
            // 
            this.textBox_publisher.Location = new System.Drawing.Point(146, 209);
            this.textBox_publisher.Multiline = true;
            this.textBox_publisher.Name = "textBox_publisher";
            this.textBox_publisher.Size = new System.Drawing.Size(325, 28);
            this.textBox_publisher.TabIndex = 26;
            // 
            // textBox_id
            // 
            this.textBox_id.Location = new System.Drawing.Point(146, 29);
            this.textBox_id.Multiline = true;
            this.textBox_id.Name = "textBox_id";
            this.textBox_id.Size = new System.Drawing.Size(325, 28);
            this.textBox_id.TabIndex = 25;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(53, 83);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(30, 17);
            this.label6.TabIndex = 24;
            this.label6.Text = "title";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(53, 127);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(49, 17);
            this.label5.TabIndex = 23;
            this.label5.Text = "author";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(53, 175);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(39, 17);
            this.label4.TabIndex = 22;
            this.label4.Text = "price";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(53, 220);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(66, 17);
            this.label3.TabIndex = 21;
            this.label3.Text = "publisher";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(94, 405);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(57, 17);
            this.label2.TabIndex = 20;
            this.label2.Text = "Kết quả";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(53, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(19, 17);
            this.label1.TabIndex = 19;
            this.label1.Text = "id";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.listBox);
            this.Controls.Add(this.button_ds);
            this.Controls.Add(this.button_dsID);
            this.Controls.Add(this.button_dsAuthour);
            this.Controls.Add(this.button_dsPub);
            this.Controls.Add(this.button_remove);
            this.Controls.Add(this.button_add);
            this.Controls.Add(this.textBox_title);
            this.Controls.Add(this.textBox_author);
            this.Controls.Add(this.textBox_price);
            this.Controls.Add(this.textBox_kq);
            this.Controls.Add(this.textBox_publisher);
            this.Controls.Add(this.textBox_id);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox listBox;
        private System.Windows.Forms.Button button_ds;
        private System.Windows.Forms.Button button_dsID;
        private System.Windows.Forms.Button button_dsAuthour;
        private System.Windows.Forms.Button button_dsPub;
        private System.Windows.Forms.Button button_remove;
        private System.Windows.Forms.Button button_add;
        private System.Windows.Forms.TextBox textBox_title;
        private System.Windows.Forms.TextBox textBox_author;
        private System.Windows.Forms.TextBox textBox_price;
        private System.Windows.Forms.TextBox textBox_kq;
        private System.Windows.Forms.TextBox textBox_publisher;
        private System.Windows.Forms.TextBox textBox_id;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
    }
}

