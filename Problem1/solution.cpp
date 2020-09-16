#include <bits/stdc++.h>
#include <iostream>
#include <stdio.h>
#include <cstdio>
#include <cstdlib>

using namespace std;

int main()
{
   freopen("sample_input.txt", "r", stdin);
   freopen("sample_output.txt", "w", stdout);
   int numOfScenarios = 0, numOfChair = 0, numOfPerson = 0, LE =0, RE=0, newOccupiedPlace=0, newRemainingPlace=0;

   cin>>numOfScenarios;
   for (int i=0;i<numOfScenarios;++i)
   {
      cin>>numOfChair>>numOfPerson;

      newOccupiedPlace = (numOfPerson + (numOfPerson +1));
      newRemainingPlace = (numOfChair - newOccupiedPlace);
      if(newOccupiedPlace < numOfChair)
      {
         if(newRemainingPlace/2 > 0)
         {
            if(newRemainingPlace >= numOfPerson)
               RE = (newRemainingPlace/2 + 1);
            else
            {
               RE = LE = 1;
               cout<<"Scenario-"<<i+1<<":"<<" "<<LE<<" "<<RE<<endl;
               continue;
            }
            if(RE < numOfPerson)
               LE = (newRemainingPlace - RE);
            else
               LE = (numOfChair - numOfPerson - RE);
         }
         else
            LE = RE = 1;
         cout<<"Scenario-"<<i+1<<":"<<" "<<LE<<" "<<RE<<endl;
      }
      else
         cout<<"Scenario-"<<i+1<<":"<<" "<<0<<" "<<0<<endl;
   }
   return 0;
}
