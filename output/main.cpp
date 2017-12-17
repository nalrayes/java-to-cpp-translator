#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test002;

int main(void) {
  A a =  __A::__init(new __A());
  Object o = a;
  std::cout << ({__rt::checkNotNull(o); o->__vptr->toString(o);}) << std::endl;
  return 0;
}
