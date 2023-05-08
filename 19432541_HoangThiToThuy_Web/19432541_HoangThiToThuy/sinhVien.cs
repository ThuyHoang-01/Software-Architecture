using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace _19432541_HoangThiToThuy
{
    public class sinhVien
    {
        public string ma { get; set; }
        public string ten { get; set; }
        public string lop { get; set; }
        public string khoa { get; set; }
        public int tuoi { get; set; }
        public static int Count { get; internal set; }

        public sinhVien(string ma, string ten, string lop, string khoa, int tuoi)
        {
            this.ma = ma;
            this.ten = ten;
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