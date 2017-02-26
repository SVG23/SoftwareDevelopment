#opening the file
file=open("HMXPC13_DI_v2_5-14-14.csv","r")

#initializing the lists and dictionary
CountryList=[]
CourseList=[]
popularCourseList=[]
countrycourseDict={}
maleList=[]
femaleList=[]
courseLists=[]
countLine=0
courseName={}
NamesList=[]

#cleaning the data and processing it
for line in file:
     if 'Other North & Central Amer., Caribbean' in line:
          #print("entered")
          line=line.replace("Other North & Central Amer., Caribbean", "Other North & Central America/Caribbean")
          #print(line)
     if countLine !=0:
          line=line.strip().split(",")
          if line[6]!="Unknown/Other":
              tuple=line[6]
              CountryList.append(tuple)
              tuple=line[0]
              CourseList.append(tuple)
              tuple=line[0],line[6]
              if tuple in countrycourseDict:
                  countrycourseDict[tuple]+=1
              else:
                    countrycourseDict[tuple]=1
              if line[9]=='m':              
                  tuple=line[0],line[6],line[9]
                  if tuple in countrycourseDict:
                      countrycourseDict[tuple]+=1
                  else:
                      countrycourseDict[tuple]=1
              if line[9]=='f':              
                  tuple=line[0],line[6],line[9]
                  if tuple in countrycourseDict:
                      countrycourseDict[tuple]+=1
                  else:
                      countrycourseDict[tuple]=1    
                         
     countLine+=1
file.close()     

#sorting and calculating unique country and course lists
CountryList=sorted(list(set(CountryList)))
CourseList=sorted(list(set(CourseList)))

file=open("CourseName.csv","r")
for line in file:
     line=line.strip().split(",")
     line[1]=line[1].rstrip()
     line[2]=line[2].strip()
     courseName[line[1]]=line[2]
    
file.close()

#defining PopularCourse function
def PopularCourse(countrycourseDict1,CourseList1,CountryList1,courseName1):
     popularCourseList1=[]                    
     append=popularCourseList1.append
    
     
     for course in CourseList1:
          for country in CountryList1:
          
               tuple=course,country,'m'
               if tuple in countrycourseDict1:
                    countrym=countrycourseDict1[tuple]
               else:
                    countrym=0
               tuple=course,country,'f'
               if tuple in countrycourseDict1:
                    countryf=countrycourseDict1[tuple]
               else:
                    countryf=0
               tuple=course,country
               if tuple in countrycourseDict1:
                    count=countrycourseDict1[tuple]
               else:
                    count=0
               course1=course.strip().split('/')
               tuple=course1[1]+'/'+course1[2]
               coursetitle=courseName1[tuple]
               if '\xa0' in coursetitle:
                   coursetitle=coursetitle.replace('\xa0','')
               if country=="United States":
                   country="USA"
               elif country=="India":
                   country="IND"
                
               tuple=count,country,coursetitle,countrym,countryf
               append(tuple)
     popularCourseList1 .sort(reverse=True)#ascending order
     
     return  popularCourseList1#returning values
               
popularCourseList= PopularCourse(countrycourseDict,CourseList,CountryList,courseName)
sorted(popularCourseList)

print("*******************************************************************************************")
print("{:11s}{:15s}{:20s}{:15s}{:10s}".format("Count","Country","Course","CountMale","CountFemale"))
print("********************************************************************************************")
print('\n'.join(map(str,popularCourseList[:10])))

for i in range(0,10):
    maleList.append(popularCourseList[i][3])
    femaleList.append(popularCourseList[i][4])
    countrycourse=popularCourseList[i][2]+','+popularCourseList[i][1]
    courseLists.append(countrycourse)


import numpy as np
import matplotlib.pyplot as plt

N = 10
MaleParticipants = (maleList)

ind = np.arange(N)  # the x locations for the groups
width = 0.30      # the width of the bars
fig, ax = plt.subplots()
rects1 = ax.bar(ind, MaleParticipants, width, color='r')

FemaleParticipants = (femaleList)
rects2 = ax.bar(ind+width, FemaleParticipants, width, color='y')

# add some text for labels, title and axes ticks
ax.set_ylabel('Count')
ax.set_title('Popular Courses based on Country and Gender')
ax.set_xticks(ind+width)
ax.set_xticklabels(courseLists, rotation='horizontal' )
ax.set_xtickangle=-360 

ax.legend( (rects1[0], rects2[0]), ('Male', 'Female') )

def autolabel(rects):
    # attach some text labels
    for rect in rects:
        height = rect.get_height()
        ax.text(rect.get_x()+rect.get_width()/2., 1.07*height, '%d'%int(height),
                ha='center', va='bottom')

autolabel(rects1)
autolabel(rects2)

plt.show()
