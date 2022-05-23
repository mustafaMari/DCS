using Service_Client.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service_Client
{
    class Program
    {
        static void Main(string[] args)
        {
            ComplexCalcClient client1 = new ComplexCalcClient("WSHttpBinding_IComplexCalc");
            ComplexNum cnum1 = new ComplexNum();
            cnum1.real = 1.2;
            cnum1.imag = 3.4;
            ComplexNum cnum2 = new ComplexNum();
            cnum2.real = 5.6;
            cnum2.imag = 7.8;
            Console.WriteLine("\nCLIENT1 - START");
            Console.WriteLine("...calling addCNum(...)");
            ComplexNum result1 = client1.addCNum(cnum1, cnum2);
            Console.WriteLine(" addCNum(...) = ({0},{1})", result1.real, result1.imag);
            Console.WriteLine("--> Press ENTER to continue");
            Console.ReadLine();
            client1.Close();
            Console.WriteLine("CLIENT1 - STOP");
        }
    }
}
