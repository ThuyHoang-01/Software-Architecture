using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace OnTap_TH3
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
        public string add (string maSv, string fullName, string lop, string khoa, int tuoi)
        {
            sinhVien sinhVien = new sinhVien(maSv, fullName, lop, khoa, tuoi);
            listSinhVien.Add(sinhVien);
            return "Đã Thêm Thành Công";
        }
        [WebMethod]
        public List<sinhVien> listDS()
        {

            return listSinhVien;
        }
       
        // search id
        [WebMethod]
        public sinhVien ds_id(string id)
        {
            for(int i=0; i < listSinhVien.Count; i++)
            {
                if (listSinhVien[i].maSV == id)
                {
                    return listSinhVien[i];
                }
            }

            return null;
        }
        //tìm kiếm theo tên
        [WebMethod]
        public List<sinhVien> ds_theoTen(String ten)
        {
            List<sinhVien> sinhVien_Ten = new List<sinhVien>();
            for (int i = 0; i < listSinhVien.Count; i++)
            {
                if (listSinhVien[i].fullName == ten)
                {
                    sinhVien_Ten.Add(listSinhVien[i]);
                }
            }
            return sinhVien_Ten;
        }
        // xóa thành viên
        [WebMethod]
        public bool xoaThanhVien(string id)
        {
            for (int i = 0; i < listSinhVien.Count; i++)
            {
                if (listSinhVien[i].maSV == id)
                {
                    listSinhVien.Remove(listSinhVien[i]);
                    return true;
                }
            }
            return false;
        }
    }
}
