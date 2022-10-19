using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuanLyBenhNhan
{
    [Serializable]
    public class BenhNhan
    {
        public long BenhNhanId { get; set; }
        public string SoCMND { get; set; }
        public string HovaTen { get; set; }
        public string DiaChi { get; set; }
        public BenhNhan() : this(0, "x","x","x")
        {
        }
        public BenhNhan(long id, string cmnd, string hvt, string diachi)
        {
            BenhNhanId = id; SoCMND = cmnd; HovaTen = hvt; DiaChi = diachi;
        }
        
        public override string ToString()
        {
            return BenhNhanId + "\t" + SoCMND + "\t" + HovaTen + "\t" + DiaChi;
        }
    }
}
