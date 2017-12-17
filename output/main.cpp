#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test003;

int main(void) {
<<<<<<< HEAD
  A a =  __A::__init(new __A("A"));
=======
  A a =  __A::__init(new __A, __rt::literal("A"));
>>>>>>> f778f90af7d2a571eb400ea165f4ac38d3647a48
  std::cout << ({__rt::checkNotNull(a); a->__vptr->getFld(a);}) << std::endl;
  return 0;
}
