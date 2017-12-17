#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test002;

int main(void) {
<<<<<<< HEAD
  A a =  __A::__init(new __A();
  std::cout << ({__rt::checkNotNull(a); a->__vptr->toString(a)}) << std::endl;
=======
  A a =  __A::__init(new __A());
<<<<<<< HEAD
  Object o = a;
  std::cout << ({__rt::checkNotNull(o); o->__vptr->toString(o);}) << std::endl;
=======
  std::cout << ({__rt::checkNotNull(a); a->__vptr->toString(a);}) << std::endl;
>>>>>>> e1f5cb750f05c586870e816fc91eed984756f8a0
>>>>>>> 819476b2c6832908c2e1afe34479df8907b2484d
  return 0;
}
