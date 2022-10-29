using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuanLySanPham
{
    public class SanPham
    {
        public long SanPhamId { get; set; }
        public string TenSP { get; set; }
        public string SoLuong { get; set; }
        public string Loai { get; set; }
        public string DiaChi { get; set; }


        public SanPham() : this(0, "x", "x", "x","x")
        {

        }

        public SanPham(long id, string tensp, string soluong, string loai , string diachi)
        {
            SanPhamId = id;
            TenSP = tensp;
            SoLuong = soluong;
            Loai = loai;
            DiaChi = diachi;
        }

        public override string ToString()
        {
            return SanPhamId + "\t" + TenSP + "\t" + SoLuong + "\t" + Loai +"\t" + DiaChi;
        }
    }
}
