/*
 * Problem2.cpp
 *
 *  Created on: 16-Sep-2020
 *      Author: A693009
 */

#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

unsigned long long int getLuckyNumber(unsigned long long int number)
{
	unsigned long long int luckyNum;
	vector<unsigned long long int> segNum;
	for(auto i=number; i>0; i--)
	{
		auto tempNum = i;
		while(tempNum != 0)
		{
			segNum.insert(segNum.begin(), tempNum%10);
		    tempNum = tempNum/10;
		}

		if(is_sorted(segNum.begin(),segNum.end()))
		{
			luckyNum=i;
			break;
		}
		segNum.clear();
	}

	return luckyNum;
}

int main()
{
	unsigned long long int count=0;
	vector<unsigned long long int> numberList;
	fstream newfile;
	newfile.open("Problem2_input.txt",ios::in);
	if (newfile.is_open())
	{
		string tp;
		while(getline(newfile, tp))
		{
			if(count==0)
				count = std::stoull(tp);
			else
			{
				if(count != 0)
				{
					numberList.push_back(std::stoull(tp));
					count--;
				}
			}
		}
		newfile.close();
	}

	newfile.open("output.txt",ios::out);
	if(newfile.is_open())
	{
		int i = 0;
		for(auto &it:numberList)
		{
			newfile << "Request-" << ++i << ": " << getLuckyNumber(it) << endl;
		}
		newfile.close();
	}
	return 0;
}

