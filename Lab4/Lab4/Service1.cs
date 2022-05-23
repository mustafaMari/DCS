using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using WcfService1;

namespace WcfServiceContract1
{
    public class MyCalculator : ICalculator
    {
        public double Add(double val1, double val2)
        {
            return val1 + val2;
 }
        public double Sub(double val1, double val2)
        {
            return val1 - val2;
        }
        public double Multiply(double val1, double val2)
        {
            return val1 * val2;
        }
    }
}