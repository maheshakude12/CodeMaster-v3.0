#include <iostream>
#include<vector>
#include <algorithm>
using namespace std;
vector<int> d;
void testLucky()
{
    for (int i = 0; i < d.size()-1; i++)
    {
        if(d[i]>d[i+1])
        {
            if(d[i]==0)
                d[i] = 9;
            else
                d[i] = d[i] - 1;
            for(int j = i+1; j< d.size(); j++ )
            {
                d[j] = 9;
            }
        }
    }

}
int main()
{
    int input;
    unsigned long long int num, finNum;
    cin>>input;
    vector<unsigned long long int> myVec;
    while(input--)
    {
        cin>>num;
        myVec.push_back(num);
    }
    for (int i = 0; i < myVec.size(); i++)
    {
        d.clear();
        finNum=0;
        while(myVec[i])
        {
            d.push_back(myVec[i] % 10);
            myVec[i] = myVec[i] / 10;
        }
        reverse(d.begin(), d.end());
        testLucky();
        int zero=20;
        while(zero--)
        if (find(d.begin(), d.end(), 0) != d.end())
        {
             testLucky();
        }
        for (int i = 0; i < d.size(); i++)
        {
             finNum = finNum * 10 + d[i];
        }
        cout<<"Request-"<<i+1<<": "<<finNum<<endl;
    }
    return 0;
}
