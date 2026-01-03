#include "aplusb.h"
#include <vector>

std::vector<int> tempA;
std::vector<int> tempB;

void initialize(std::vector<int> A, std::vector<int> B) {
  tempA = A;
  tempB = B;
  return;
}

int answer_question(int i, int j) {
  return tempA[i] + tempB[j];
}
