using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Service_Contract
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in both code and config file together.
    public class MyComplexCalc : ClientBase<IComplexCalc>, IComplexCalc
    {
        public MyComplexCalc() {}
        public MyComplexCalc(string endpointConfigurationName) :
        base(endpointConfigurationName)
        {
        }

        public ComplexNum addCNum(ComplexNum n1, ComplexNum n2)
        {
            Console.WriteLine("...called addCNum(...)");
            return new ComplexNum(n1.real + n2.real, n1.imag + n2.imag);

        }
    }
}
