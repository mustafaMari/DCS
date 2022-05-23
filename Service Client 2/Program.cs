using Service_Contract;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.Text;
using System.Threading.Tasks;

namespace Service_Client_2
{
    class Program
    {
        static void Main(string[] args)
        {
            // Step 1 Create the URI of service base address
            Uri baseAddress = new Uri("http://localhost:1000/baseName");
            // Step 2 Create service instance.
            ServiceHost myHost = new
            ServiceHost(typeof(MyComplexCalc), baseAddress);
            // Step 3 Add the endpoint.
            BasicHttpBinding myBinding = new BasicHttpBinding();
            ServiceEndpoint endpoint1 = myHost.AddServiceEndpoint(
            typeof(IComplexCalc),
            myBinding,
            "endpoint1");
            // Step 4 Set up metadata and publish service metadata
            ServiceMetadataBehavior smb = new ServiceMetadataBehavior();
            smb.HttpGetEnabled = true;
            myHost.Description.Behaviors.Add(smb);
            // Step 5 Run the service.
            try
            {
                myHost.Open();
                Console.WriteLine("\n---> Endpoints:");
                // copy below code for each endpoint:
                //endpoint1
                Console.WriteLine("\nService endpoint {0}:", endpoint1.Name);
                Console.WriteLine("Binding: {0}", endpoint1.Binding.ToString());
                Console.WriteLine("ListenUri: {0}", endpoint1.ListenUri.ToString());
                //endpoint2
                Console.WriteLine("-->Service started.");
                Console.WriteLine("-->Press <ENTER> to STOP service...");
                Console.WriteLine();
                Console.ReadLine(); // to not finish app immediately:
                myHost.Close();
                Console.WriteLine("--> ComplexCalculator finished");

            }
            catch (CommunicationException ce)
            {
                Console.WriteLine("-->Exception occurred: {0}", ce.Message);
                Console.ReadLine(); // to not finish app immediately:
                myHost.Abort();

            }
        }
    }
}
