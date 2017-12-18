#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test020;

int main(void) {
  int x;
  x = A->x;
  std::cout << ({__rt::checkNotNull(A); A->__vptr->x(A);}) << std::endl;
  return 0;
}
