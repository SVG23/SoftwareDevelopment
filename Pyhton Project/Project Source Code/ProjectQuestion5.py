import matplotlib.pyplot as plt
import cartopy
import cartopy.io.shapereader as shpreader
import cartopy.crs as ccrs


#opening the file
file=open("HMXPC13_DI_v2_5-14-14.csv","r")

#initializing lists and dictionaries
MoocList=[]
CountryList=[]
countLine=0
literacyrate={}
Country={}
literacy={}
CountryLiteracy={}
internetusers={}

#reading the data from the file and cleaning it
for line in file:
     if(countLine != 0): #only if there is atleast one line we are starting the process    
      if 'Other North & Central Amer., Caribbean' in line:
          line=line.replace('"Other North & Central Amer., Caribbean"', 'Other North & Central America/Caribbean')
      if 'Russian Federation' in line:
          line=line.replace('Russian Federation', 'Russia')
      line=line.strip().split(",")
      tuple=line[6]
      CountryList.append(tuple)#taking countries to a list
      tuple=line[1],line[6]#taking countries along with user ids
      MoocList.append(tuple)  
     countLine+=1
file.close() # Closing file

file=open("IULIST.csv","r")#opening coutry internet users and literacy rate list

#reading and processing the list
for line in file:
     line=line.strip().split(",")
     
     line[0]=line[0].lstrip()
     internetusers[line[0]]=line[1]
file.close()

file=open("Literacy_Rate.csv","r")
for line in file:
     line=line.strip().split(",")
     line[0]=line[0].lstrip()
     literacyrate[line[0]]=line[1]
file.close()

#finding unique country and userids
CountryList=sorted(list(set(CountryList)))
MoocList=list(set(MoocList))
for country in CountryList:
     if country in literacyrate:
          literacy[country]=(float(internetusers[country])*(float(literacyrate[country])))/100

#calculating number of unique users for country
for country in CountryList:
     Country[country]=0
for i in range(1,len(MoocList)):
     Country[MoocList[i][1]]+=1

#calculating the percetage of MOOC users with countries internet users
for country in CountryList:
     if country in literacy:
          CountryLiteracy[country]= [int(Country[country]), round((float(Country[country])/float(literacy[country]))*100, 3)]

#printing the items of dictionary
print("*********************************")
print("{:11s}{:20s}".format("Country","Percentage"))
print("**********************************")
for key, val in CountryLiteracy.items():
     print(key, ":", val)    

ax = plt.axes(projection=ccrs.PlateCarree())
ax.add_feature(cartopy.feature.OCEAN) # show the ocean in the map

# draw the map. this connects to the URL mentioned in site_config.py in cartopy pakcage
shpfilename = shpreader.natural_earth(resolution='110m',
                                      category='cultural',
                                      name='admin_0_countries')
reader = shpreader.Reader(shpfilename)
countries = reader.records()

for country in countries:
    col = (0, 0, 0)
    if country.attributes['brk_name'] in CountryLiteracy:
        if CountryLiteracy[country.attributes['brk_name']][1] >=0 and CountryLiteracy[country.attributes['brk_name']][1] <= 0.004:
            col = (1, 1, 0)
        elif CountryLiteracy[country.attributes['brk_name']][1] >=0.005 and CountryLiteracy[country.attributes['brk_name']][1] <= 0.009:
            col = (1, 0, 1)
        elif CountryLiteracy[country.attributes['brk_name']][1] >=0.01 and CountryLiteracy[country.attributes['brk_name']][1] <= 0.04:
            col = (0, 1, 0)
        elif CountryLiteracy[country.attributes['brk_name']][1] >=0.041 and CountryLiteracy[country.attributes['brk_name']][1] <= 0.1:
            col = (1, 0, 0)
        
        ax.add_geometries(country.geometry, ccrs.PlateCarree(),
                          facecolor= col,
                          label=country.attributes['adm0_a3'])
    else:
        ax.add_geometries(country.geometry, ccrs.PlateCarree(),
                          facecolor=(1, 1, 1),
                          label=country.attributes['adm0_a3'])

plt.show()          
