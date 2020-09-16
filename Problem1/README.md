# Social Distancing

Post COVID-19, social distancing will be new normal for sure, many places such rules have been implemented. Even our office canteen doing the same.
In our newly designed canteen, we will have only one long-running table with only one side sitting (no face to face).
With both corners occupied with a person checking everyone's temperature leaving '**C**' number of chairs in between at start.

The rules are as below so that while choosing any chair, people should be sitting as far as possible from others.
For each empty chair, a person should count empty chairs from the nearest person sitting on both sides, say left empty **(LE)** and right empty **(RE)**.

**Rule 1**: Person can choose a chair where the minimum of LE & RE is higher, if many options then go with Rule 2.

**Rule 2**: Person can choose a chair where the maximum of LE & RE is higher, if still many options then sit on the leftmost chair from Rule 1 options.

If we have '**P**' number of people coming in the canteen one after another and choosing a chair on 1st come 1st serve basis.
So imagine you are the last person to enter the canteen, what will values of **maximum** and **minimum** among LE and RE for the chair you choose.

## Input

The first line gives the number of scenarios, say '**S**'. '**S**' scenario to follow.

For each scenario, have two numbers i.e. '**C**' and '**P**' as described above. 

## Output

For each scenario, the output should be like "**Scenario-S: X Y**",

Where '**S**' is the scenario number, and '**X**' is the '**maximum**' and '**Y**' is the '**minimum**' among LE and RE respectively for the last chair chosen.

## Important Note

We need **output.txt** generated based on provided **Problem1_input.txt**.

### Sample Input
```
4
6 2
1000 1000
3 2
100 1
```

### Sample Output

```
Scenario-1: 1 1
Scenario-2: 0 0
Scenario-3: 0 0
Scenario-4: 50 49
```

In the above Scenario-1, when 1st person enters in the canteen, the table must be look like below,

X _ _ _ _ _ _ X where (X means occupied and _ means empty chair).

1st person will run Rule 1 but it comes with multiple choices, so he/she runs Rule 2 but results again in multiple options. 
So he/she will choose left most chair from Rule 1 options.
So the table will look like X _ _ X _ _ _ X

2nd person who is last as well, runs Rule 1 and choose the middle chair between 3 empty chairs.
Which results in the table as X _ _ X _ X _ X

So when the above(i.e. last) person made choice he/she has one chair empty on either side which makes maximum and minimum as 1.

Hence, the result as **Scenario-1: 1 1**

