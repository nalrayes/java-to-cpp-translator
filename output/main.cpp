#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test018;

int __A::x;
int main(int argc, char* argv[]) {
  __rt::Array<String> args = new __rt::__Array<String>(argc - 1);
  for (int32_t i = 1; i < argc; i++) {
    (*args)[i] = __rt::literal(argv[i]);
  }
  {__A::x = 3;
  }
  std::cout << __A::x << std::endl;
  return 0;
}
