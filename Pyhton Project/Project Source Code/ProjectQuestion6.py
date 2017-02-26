#opening file
file=open("HMXPC13_DI_v2_5-14-14.csv","r")

#initializing lists
MoocList=[]
certifiedList=[]
courseList=[]
coursecertifiedList=[]
coursecertifiedList1=[]
ratiocerList=[]
ratioregList=[]
courseNameDict={}
CourseNameList=[]
courseNames=[]
displaycourseList=[]

#reading data from file
for line in file:
    MoocList.append(line.strip().split(","))
    
#defining function for calcuating ratios of users
def CompletedRatio(MoocList,courseNameDict):
    for i in range(1,len(MoocList)):
        if MoocList[i][0] not in courseList:#creating unique course list
            tuple=MoocList[i][0]
            courseList.append(tuple)
    file=open("CourseName.csv","r")
    for line in file:
        line=line.strip().split(",")
        line[1]=line[1].rstrip()
        line[2]=line[2].strip()
        courseNameDict[line[1]]=line[2]
     
    file.close()
        
    for j in range(0,len(courseList)):#calculating count of certified,registered users with the total users in MOOC
        coursename=courseList[j]
        for line in courseList:
            line=line.strip().split("/")
            code=line[1]+"/"+line[2]
            if code in courseNameDict:
                tempstr=courseNameDict[code]
            displaycourseList.append(tempstr)
        countcer=0
        countreg=0
        length=len(MoocList)
        for i in range(1,len(MoocList)):
            if courseList[j]==MoocList[i][0] and MoocList[i][5]=='1':#calculating number of users who certified for a given course
                countcer=countcer+1
            if courseList[j]==MoocList[i][0] and MoocList[i][4]=='1':#calculating number of users who registered for a given course
                countreg=countreg+1
                
        tuple=coursename,countreg,countcer
        coursecertifiedList.append(tuple)
    
        tuple=countreg
        ratioregList.append(tuple)
        tuple=countcer
        ratiocerList.append(tuple)
         
        coursecertifiedList1=sorted(coursecertifiedList,key=lambda x: x[1],reverse=True)
        
    print("**************************************************************************************************************************")
    print("{:20s}{:15s}{:12s}".format("Course","ExploredCount","CertCount"))
    print("***************************************************************************************************************************")
    for elem in coursecertifiedList1:
        print(elem)
            
CompletedRatio(MoocList,courseNameDict)

import numpy as np
import matplotlib.pyplot as plt

N = 16

ratioreg = (ratioregList)

ind = np.arange(N)  # the x locations for the groups
width = 0.40       # the width of the bars
fig, ax = plt.subplots()
rects1 = ax.bar(ind, ratioreg, width, color='y')

ratiocertified = (ratiocerList)
rects2 = ax.bar(ind+width, ratiocertified, width, color='b')

# add some text for labels, title and axes ticks
ax.set_ylabel('Count')
ax.set_title('Number of Students Explored vs Certified per Course')
ax.set_xticks(ind+width)
ax.set_xticklabels( (displaycourseList), rotation='horizontal' )
ax.set_xtickangle=-360 

ax.legend( (rects1[0], rects2[0]), ('Count Explored', 'Count Certified') )

def autolabel(rects):
    # attach some text labels
    for rect in rects:
        height = rect.get_height()
        ax.text(rect.get_x()+rect.get_width()/2., 1.05*height, '%d'%int(height),
                ha='center', va='bottom')

autolabel(rects1)
autolabel(rects2)

plt.show()
                