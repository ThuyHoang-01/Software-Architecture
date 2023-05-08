using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace _19432541_HoangThiToThuy
{
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {
        public static List<sinhVien> listSinhVien = new List<sinhVien>();

        [WebMethod]
        public string add(string ma, string ten, string lop, string khoa, int tuoi)
        {
            sinhVien sinhVien = new sinhVien(ma, ten, lop, khoa, tuoi);
            listSinhVien.Add(sinhVien);
            return "Thêm thành công";
        }
        // sửa
        [WebMethod]
 
        public bool UpdateStudent(string ma, string ten, string lop, string khoa, int tuoi)
        {
            sinhVien s = ds_id(ma);
            if (s != null)
            {
                listSinhVien.Remove(s);
                s = new sinhVien(ma, ten, lop, khoa, tuoi);
                listSinhVien.Add(s);
                return true;
            }
            return false;
        }


        [WebMethod]

        public List<sinhVien> listDS()
        {
            return listSinhVien;
        }
        //hàm tìm kiếm theo id
        [WebMethod]
        public sinhVien ds_id(String id)
        {
            for (int i = 0; i < listSinhVien.Count; i++)
            {
                if (listSinhVien[i].ma == id)
                {
                    return listSinhVien[i];
                }
            }
            return null;
        }
        //hàm tìm kiếm theo ten 
        [WebMethod]
        public List<sinhVien> ds_theoTen(String ten)
        {
            List<sinhVien> sinhVien_Ten = new List<sinhVien>();
            for (int i = 0; i < listSinhVien.Count; i++)
            {
                if (listSinhVien[i].ten == ten)
                {
                    sinhVien_Ten.Add(listSinhVien[i]);
                }
            }
            return sinhVien_Ten;
        }
        //hàm xóa thành viên
        [WebMethod]
        public bool xoaThanhVien(string id)
        {

            for (int i = 0; i < listSinhVien.Count; i++)
            {
                if (listSinhVien[i].ma == id)
                {
                    listSinhVien.Remove(listSinhVien[i]);
                    return true;
                }
            }
            return false;
        }
    }
}
    

