#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int nums[5];
char colors[5];

int getScore() {
	bool isContinuos = true;
	for(int i=0;i<4;i++)
		isContinuos &= (nums[i+1] - nums[i] == 1);
		
	if(isContinuos && colors[0] == colors[4]) 
		return nums[4] + 900;
	
	if(nums[0] == nums[3] || nums[1] == nums[4]) 
		return nums[2] + 800;
	
	if(nums[0] == nums[2] && nums[3] == nums[4]) 
		return nums[0] * 10 + nums[3] + 700;
	if(nums[0] == nums[1] && nums[2] == nums[4]) 
		return nums[4] * 10 + nums[0] + 700;
	
	if(colors[0] == colors[4]) 
		return nums[4] + 600;
	
	if(isContinuos && abs(nums[0]-nums[4])==4)
		return nums[4] + 500;
	
	if(nums[0] == nums[2] || nums[1] == nums[3] || nums[2]==nums[4])
		return nums[2] + 400;

	if((nums[0]==nums[1] && (nums[2] == nums[3] || nums[3] == nums[4])) || (nums[1]==nums[2] && nums[3]==nums[4]))
		return nums[3] * 10 + nums[1] + 300;
	
	for(int i=0;i<4;i++)
		if(nums[i] == nums[i+1])
			return nums[i] + 200;
			
	return nums[4] + 100;
}

int main() {
	for (int i = 0; i < 5; i++) {
		scanf(" %c %d",&colors[i], &nums[i]);
	}
	
	sort(colors,colors+5);
	sort(nums,nums+5);
	
	printf("%d\n",getScore());
}