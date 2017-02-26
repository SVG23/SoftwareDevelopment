from collections import defaultdict

file=open("HMXPC13_DI_v2_5-14-14.csv","r")
users_set = set()
MoocDict = defaultdict(set) # use defaultdict with values that are set
FinalDict = defaultdict(set) # use defaultdict with values that are set
cnt = 0

for line in file:
    if cnt != 0:
        tempList = []
        tempList.append(line.strip().split(",")) 
        users_set.add(tempList[0][1])    # use a set to find the distinct number of users
        if tempList[0][3] == '1':
            tempstr = tempList[0][0]
            newstr = tempstr[tempstr.find('/') + 1 : tempstr.find('/', tempstr.find('/') + 1)] # strip the course to get just the code
            MoocDict[tempList[0][1]].add(newstr) # create a dictionary with key as user_id and value as the course_code
    cnt += 1;
file.close() # Close file once done

print("Total Number of individual users on edX between 2012 and 2013 ::", len(users_set))
print("Out of these, users who atleast explored course material      ::", len(MoocDict))

for key, value in MoocDict.items():
    if len(value) > 1:
        for el in value:
            FinalDict[key].add(el) # create a dictionary of users who accessed multiple courses

print("\nOut of these, Number of users who explored multiple courses   ::", len(FinalDict))

# create a dictionary based on the courses in the data set, grouping it by the field
courseDict = {'History':{'CB22x'}, 'CS':{'CS50x','6.00x'}, 
              'Social Science':{'ER22x','14.73x'}, 'Health':{'PH207x','PH278x'},
              'Electronics':{'6.002x'},'Chemistry':{'3.091x','2.01x'},'Physics':{'8.02x'},
              'Biology':{'7.00x'}, 'Mechanics':{'8.MReV'}
              }

mul_course_cnt = 0
for key, value in FinalDict.items():
   for el in value:
       for k,v in courseDict.items():
           if el in v:
               if len(value.difference(v)) > 1: # use set difference to find those users who have taken courses not in only one field
                   mul_course_cnt += 1
                   break

print("Amongst these, users who explored courses in different fields ::", mul_course_cnt)
