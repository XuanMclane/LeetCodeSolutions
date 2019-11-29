//https://leetcode.com/problems/defanging-an-ip-address/
using System.Text;

public class DefangIPaddr
{
  public string Solution(string address)
  {
    return address == null ? null : string.Join("[.]", address.Split('.'));
  }
}