#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test003;

int main(void) {
  A a =  __A::__init(new __A, __rt::literal("A"));
  std::cout << ({__rt::checkNotNull(a); a->__vptr->getFld(a);}) << std::endl;
  return 0;
}
