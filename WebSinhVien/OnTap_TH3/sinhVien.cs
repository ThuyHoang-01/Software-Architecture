using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace OnTap_TH3
{
    public class sinhVien
    {
        public string maSV { get; set; }
        public string fullName { get; set; }
        public string lop { get; set; }
        public string khoa { get; set; }
        public int tuoi { get; set; }

        public sinhVien ( string maSV , string fullName , string lop , string khoa ,int tuoi)
        {
            this.maSV = maSV;
            this.fullName = fullName;
            this.lop = lop;
            this.khoa = khoa;
            this.tuoi = tuoi;
        }
        public sinhVien()
        {

        }
        public override string ToString()
        {
            return base.ToString();
        }
    }
}