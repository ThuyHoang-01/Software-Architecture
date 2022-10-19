using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuanLyBenhNhan
{
    public class BenhNhan
    {
        public long BenhNhanId { get; set; }
        public string soCMND { get; set; }
        public string HovaTen { get; set; }
        public string DiaChi { get; set; }

        public BenhNhan() : this(0, "X", "X", "X")
        {

        }

        public BenhNhan (long id , string cmnd , string hvt , string diachi)
        {
            BenhNhanId = id;
            soCMND = cmnd;
            HovaTen = hvt;
            DiaChi = diachi;
        }

        public override string ToString()
        {
            return BenhNhanId + "\t" + soCMND + "\t" + HovaTen + "\t" + DiaChi;

        }
    }
}
