# Important 

Everything needs to be deterministic:
Server A has the same transactions as server B
same results
but if CPU or other components work different,
the deterministic proprieties can fail.

Per example, double/floats are non-deterministic,
so we will use long to represent numeric values.

Then for our key-value map, we cant use HashSet or HashMap.
BFT-SMaRt recommends TreeSet or TreeMap.
But there is another data type, recommended by java documentation: LinkedHashMap.

Profiling/Benchmark:
The Big Oh for LinkedHashMap is O(N) and for TreeMap is O(logN),
which is slower for the operations we want to do, which are:

createAccount, deposit, withdraw, transfer and getBalance.

To satisfy the attack pahse, we will run the BankServer with a second argument

./smartrun.sh com.byzantine.BankServer <id> malicious

and then on MaliciousBank i can have a forceWithdraw 
where i ignore NotEnoughtFunds check, per exampe