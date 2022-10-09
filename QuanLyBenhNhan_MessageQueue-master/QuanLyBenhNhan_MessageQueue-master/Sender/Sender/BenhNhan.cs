using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sender
{
    [Serializable]
    public class BenhNhan
    {
        public String msbn { get; set; }
        public String cmnd { get; set; }
        public String hoten { get; set; }
        public String diachi { get; set; }

        public BenhNhan(string msbn, string cmnd, string hoten, string diachi)
        {
            this.msbn = msbn;
            this.cmnd = cmnd;
            this.hoten = hoten;
            this.diachi = diachi;
        }

        public BenhNhan(string msbn)
        {
            this.msbn = msbn;
        }

        public BenhNhan()
        {
        }

        public override string? ToString()
        {
            return base.ToString();
        }
    }
}
