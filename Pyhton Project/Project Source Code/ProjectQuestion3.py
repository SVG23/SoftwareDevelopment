from collections import defaultdict, OrderedDict
import matplotlib.pyplot as pyplot

file=open("HMXPC13_DI_v2_5-14-14.csv","r")
MoocList=[]
MoocDict = defaultdict(set) # use defaultdict with values that are set
FinalDict = defaultdict(int) # use defaultdict with integer values

for line in file:
     if 'Other North & Central Amer., Caribbean' in line:
          line=line.replace("Other North & Central Amer., Caribbean", "Other North & Central America/Caribbean")

     tempList = []
     tempList.append(line.strip().split(","))  
     if tempList[0][8].isdigit():
          MoocDict[tempList[0][8]].add(tempList[0][1]) #store year_of_birth as key and user_id as value. Its a set so will remove duplicates.

file.close() # Close file once done


for key, value in MoocDict.items():
    countList = [int(key), len(value)] # count the number of users having same year of birth and store in a list
    MoocList.append(countList)

print("Phase1 Output:")
print(sorted(MoocList))
print()

# Group information by age and create a final dictionary
for listItem in MoocList:
    if listItem[0] >= 2000:
        FinalDict["0-12 yrs"] += listItem[1]
    elif listItem[0] >= 1993:
        FinalDict["13-20 yrs"] += listItem[1]
    elif listItem[0] >= 1983:
        FinalDict["21-30 yrs"] += listItem[1]
    elif listItem[0] >= 1973:
        FinalDict["31-40 yrs"] += listItem[1]
    elif listItem[0] >= 1963:
        FinalDict["41-50 yrs"] += listItem[1]
    elif listItem[0] >= 1953:
        FinalDict["51-60 yrs"] += listItem[1]
    elif listItem[0] >= 1943:
        FinalDict["61-70 yrs"] += listItem[1]
    elif listItem[0] >= 1933:
        FinalDict["71-80 yrs"] += listItem[1]
    else:
        FinalDict["80+ yrs"] += listItem[1]
        
NewDict = OrderedDict(sorted(FinalDict.items())) # use OrderedDict package to sort the dictionary and return a dictionary
print("Phase2 Output:")
print(NewDict)
print()

pyplot.figure(1, figsize=(6,6)) # to get a circular pie

values = [v for v in NewDict.values()]
total_num_ppl = sum(values)
pct_values = [None] * len(values) # creates an empty list of desired length
for i in range(len(values)):
    pct_values[i] = round(values[i]/total_num_ppl * 100, 1) # find percentage
pie_labels = [k for k in NewDict.keys()]

for i in range(len(values)):
    pie_labels[i] = pie_labels[i] + ": " + str(pct_values[i]) + "% - " + str(values[i]) + " users"

color_list = ('red','gold','lightskyblue','lightcoral','blue','green','grey','red','cyan','pink')

patches, texts = pyplot.pie(values, colors=color_list,startangle = 90, counterclock=False,shadow=True)

pyplot.title('Pie chart showing age-groupwise MOOC participation', bbox={'facecolor':'0.8', 'pad':5})
pyplot.legend(patches, pie_labels, loc = 'best') # provide the data to plot the legend and place it at best possible location on screen
pyplot.axis('equal')
pyplot.show()
