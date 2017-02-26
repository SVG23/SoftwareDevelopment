#reading the file and initialization of Lists
file=open("HMXPC13_DI_v2_5-14-14.csv","r")
MoocList=[]
ExploredList=[]
UnExploredList=[]
LoE=[]
LoEDict={}
UnLoEDict={}
labels=[]
percentage=[]
resultList=[]
countLine=0

#reading data from the file and data cleaning
for line in file:
    if(countLine != 0):     
          if 'Other North & Central Amer., Caribbean' in line:
               line=line.replace('"Other North & Central Amer., Caribbean"', 'Other North & Central America/Caribbean')
          line=line.strip().split(",")
          tuple=line[7]
          if( tuple !='NA' and tuple !=''):
               if tuple not in LoE:
                    LoE.append(tuple)
               if line[4]=='1' :
                    tuple=line[7],line[4],line[1]
                    ExploredList.append(tuple)
               else:
                    tuple=line[7],line[4],line[1]
                    UnExploredList.append(tuple)
    countLine+=1
file.close() # Closing file

#obtaining unique values from the list     
ExploredList=list(set(ExploredList))
UnExploredList=list(set(UnExploredList))


#function for counting number of students for each level of education
def countn(ExploredList1,LoE1):
    #dictionary initialization
     LoE1Dict={}
     for education in LoE1:
          LoE1Dict[education]=0
     for education in LoE1:
         LoE1Dict[education]= sum(1 for elem in ExploredList1 if elem[0] == education)#calculating sum of users  of inidvidal education levels 
     
     return LoE1Dict#returning value

#function for calculating percentages of students of different education levels
def Percentages(LoEDict1,LoE1):
     percentage1=[]
     labels1=[]
       
     totalExplored=sum(LoEDict1[loe] for loe in LoE1)
     for education in LoE1:
          percentage=(LoEDict1[education]/totalExplored)*100
          labels1.append(education)
          percentage1.append(percentage)
          tuple=education,percentage
          resultList.append(tuple)
          
     return percentage1,labels1#returning values

LoEDict=countn(ExploredList,LoE)
print(LoEDict)
percentage,labels = Percentages(LoEDict,LoE)#calling function
print("{:11s}{:11s}".format("LOE","Percentage"))
print("**********************************************")
for elem in resultList:
    print(elem)
    
#Graphical Representation as Pie chart    
from pylab import *
import matplotlib.pyplot as pyplot

# make a square figure and axes
figure(1, figsize=(7,7))
ax = axes([0.1, 0.1, 0.8, 0.8 ])

# The slices will be ordered and plotted counter-clockwise.
labels =labels
fracs =percentage
colors = ['yellowgreen', 'gold', 'lightskyblue', 'lightcoral','blue','green','red']
explode=(0, 0.1, 0, 0, 0)

pyplot.pie(fracs, explode=explode, labels=labels,colors=colors,
                autopct='%1.1f%%', shadow=True, startangle=51)
                # The default startangle is 0, which would start
                # the Frogs slice on the x-axis.  With startangle=90,
                # everything is rotated counter-clockwise by 90 degrees,
                # so the plotting starts on the positive y-axis.

title('Level of Education of Students Registered and Explored', bbox={'facecolor':'0.8', 'pad':5})

show()
