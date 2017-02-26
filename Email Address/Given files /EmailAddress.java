import java.util.*;

/** The EmailAddress class represents an email address. Here only a
  very limited variant is used that allows an address to be defined
  and verified. A typical usage example is:
  EmailAddress ea = new EmailAddress("john@company.com");
  boolean isProper = ea.isValid();

  Please note that the implementation of isValid is on purpose WRONG!

   This source code is from the book
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author:
     Henrik B Christensen
     Department of Computer Science
     Aarhus University

   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class EmailAddress {
  private String address;

  /**
   * Verify that a string is an email address.
   * The string must obey the following (somewhat strict format)
   * <email>      ::= <identifier> @ <identifier> {. <identifier>}
   * <identifier> ::= letter { letter | digit }
   *
   * Example: abc@somewhere12.mail.com is correct whereas the
   * following are incorrect:
   *
   * 13a@s.m.com (identifier starting with digit)
   * a-c@s.m.com (non letter in identifier)
   * a.b.c (missing @)
   * abc@ (missing identifier after @)
   * @return true if the address obeys this format.
  */
  public boolean isValid() {
    // This implementation is wrong and could be expressed more
    // elegantly using regular expressions.
    if ( address == null ) return false;
    if ( address.length() == 0 ) return false;
    int atPosition = address.indexOf( '@' );
    if ( atPosition == -1 ) return false;
    return true;
  }
}
