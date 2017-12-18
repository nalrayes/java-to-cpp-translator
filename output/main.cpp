#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test027;

int main(int argc, char* argv[]) {
  __rt::Array<String> args = new __rt::__Array<String>(argc - 1);
  for (int32_t i = 1; i < argc; i++) {
    (*args)[i] = __rt::literal(argv[i]);
  }
  __rt::Array<A> as =  new __rt::__Array<A>(10);
  for (int32_t i = 0; i <({__rt::checkNotNull(as); as->length; }); i++) {
    (*as)[i] = __A::__init(new __A(), i);
  }
  int k = 0;
  while (k < 11) {
    std::cout << ({__rt::checkNotNull(__rt::java_cast<A>((*as)[k])); __rt::java_cast<A>((*as)[k])->__vptr->get(__rt::java_cast<A>((*as)[k]));}) << std::endl;
    k = k + 1;
  }
  return 0;
}
