#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test003;

int main(int argc, char* argv[]) {
  __rt::Array<String> args = new __rt::__Array<String>(argc - 1);
  for (int32_t i = 1; i < argc; i++) {
    (*args)[i] = __rt::literal(argv[i]);
  }
  A a =  __A::__init(new __A, __rt::literal("A"));
  std::cout << ({__rt::checkNotNull(a); a->__vptr->getFld(a);}) << std::endl;
  return 0;
}
