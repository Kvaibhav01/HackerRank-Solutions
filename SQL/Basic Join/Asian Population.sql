select sum(City.Population) from City INNER JOIN Country on City.CountryCode = Country.Code Where Country.Continent = 'Asia';
