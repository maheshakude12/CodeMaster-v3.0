using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace CodeMasterSolution
{
    class Data
    {
        public string number;
    }
    class Program
    {
        static void Main(string[] args)
        {
            string assemblyFilePath = System.Reflection.Assembly.GetExecutingAssembly().Location;
            string[] possiblePaths = new string[] { "CodeMasterSolution" };
            int integraleMainStart = -1;
            foreach (var item in possiblePaths)
            {
                if (assemblyFilePath.IndexOf(item) != -1)
                {
                    integraleMainStart = assemblyFilePath.IndexOf(item);
                }
            }
            string ret = assemblyFilePath.Substring(0, integraleMainStart) + "Problem2_Input.txt";
            List<Data> dta = FileRead(ret);
            dta.Remove(dta[0]);
            int count = 1;
            decimal luckyNumber;
            foreach (var item in dta)
            {
                luckyNumber = GetLuckyNumber(item.number);
                using (StreamWriter sw = new StreamWriter(assemblyFilePath.Substring(0, integraleMainStart) + "Output.txt", true))
                {
                    sw.WriteLine("Request- {0}: {1}", count, luckyNumber);
                    sw.Close();
                }
                count++;
            }
        }
        private static decimal GetLuckyNumber(string number)
        {
            long a = long.Parse(number);
            decimal no=0;
            int[] digits = number.ToString().ToCharArray().Select(x => (int)Char.GetNumericValue(x)).ToArray();
            for (long i = a; i <= a; i--)
            {
                bool isFound = true;
                int[] digits1 = i.ToString().ToCharArray().Select(x => (int)Char.GetNumericValue(x)).ToArray();

                for (int j = 0; j < digits1.Length-1; j++)
                {
                    if(!(digits1[j]<=digits1[j+1]))
                    {
                        isFound = false;
                        break;
                    }
                }
                if (isFound)
                {
                    no = i;
                    break;
                }
            }
            return no;

                }


        private static List<Data> FileRead(string filename)
        {
            List<Data> obj1 = new List<Data>();
            if (File.Exists(filename))
            {
                //    // ---------------------- READ THE FILE--------------------------------------------
                using (StreamReader file = new StreamReader(filename))
                {
                    int counter = 0;
                    string ln;
                    while ((ln = file.ReadLine()) != null)
                    {
                        Data obj = new Data();
                        string[] ar = ln.Split(" ");
                        obj.number=(Convert.ToString(ar[0]));
                        obj1.Add(obj);
                    }
                    counter++;
                }
            }
            return obj1;
        }

    }
}
