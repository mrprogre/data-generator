package com.avandy.dataset.list;

import com.avandy.dataset.util.Randomizer;

public class Lists {

    // Men
    public String getManName() {
        return menNames[Randomizer.getRandomInt(menNames.length)];
    }

    public String getManSurname() {
        return menSurnames[Randomizer.getRandomInt(menSurnames.length)];
    }

    public String getManNameAndSurname() {
        return getManName() + " " + getManSurname();
    }

    // Women
    public String getWomanName() {
        return womenNames[Randomizer.getRandomInt(womenNames.length)];
    }

    public String getSurname() {
        return menSurnames[Randomizer.getRandomInt(menSurnames.length)] + "а";
    }

    public String getWomenNameAndSurname() {
        return getWomanName() + " " + getSurname();
    }

    // Random human
    public String getRandomHuman() {
        return Randomizer.getRandomBoolean() ? getManNameAndSurname() : getWomenNameAndSurname();
    }

    public String getColor() {
        return color[Randomizer.getRandomInt(color.length)];
    }

    public String getCar() {
        return car[Randomizer.getRandomInt(car.length)];
    }

    private final String[] color = {
            "Коричневый", "Красный", "Синий", "Белый", "Чёрный", "Жёлтый", "Оранжевый",
            "Голубой", "Фиолетовый", "Розовый", "Зелёный", "Серый", "Бирюзовый"
    };

    private final String[] car = {
            "AC", "Acura", "Alfa Romeo", "Alpina", "Alpine", "Ariel", "Aro", "Asia", "Aston Martin", "Audi", "Austin",
            "Autobianchi", "Baltijas Dzips", "Beijing", "Bentley", "Bertone", "Bitter", "Blonell", "BMW", "Brilliance",
            "Bristol", "Bufori", "Bugatti", "Buick", "BYD", "Cadillac", "Callaway", "Carbodies", "Carver", "Caterham",
            "Changan", "ChangFeng", "Chery", "Chevrolet", "Chrysler", "Citroen", "Cizeta", "Coggiola", "Dacia", "Dadi",
            "Daewoo", "DAF", "Daihatsu", "Daimler", "Dallas", "De Lorean", "De Tomaso", "Derways", "Dodge", "DongFeng",
            "Doninvest", "Donkervoort", "Eagle", "FAW", "Ferrari", "Fiat", "Ford", "Foton", "FSO", "Fuqi", "Geely",
            "Geo", "GMC", "Gonow", "Great Wall", "Hafei", "Haima", "Hindustan", "Holden", "Honda", "HuangHai", "Hurtan",
            "Hyundai", "Infiniti", "Innocenti", "Invicta", "Iran Khodro", "Irmscher", "Isdera", "Isuzu", "IVECO",
            "JAC", "Jaguar", "Jeep", "Jensen", "Jiangling", "JMC", "Kia", "Koenigsegg", "KTM", "Lamborghini", "Lancia",
            "Land Rover", "Landwind", "Lexus", "Liebao Motor", "Lifan", "Lincoln", "Lotus", "LTI", "Mahindra",
            "Marcos", "Marlin", "Marussia", "Maruti", "Maserati", "Maybach", "Mazda", "Mc Laren", "MCC", "Mega",
            "Mercedes-Benz", "Mercury", "Metrocab", "MG", "Microcar", "Minelli", "Mini", "Mitsubishi", "Mitsuoka",
            "Monte Carlo", "Morgan", "Morris", "Nissan", "Noble", "Oldsmobile", "Opel", "Osca", "Pagani", "Panoz",
            "Paykan", "Perodua", "Peugeot", "Plymouth", "Pontiac", "Porsche", "Premier", "Proton", "PUCH", "Puma",
            "Qvale", "Reliant", "Renault", "Renault Samsung", "Rolls-Royce", "Ronart", "Rover", "Saab", "Saleen",
            "Saturn", "Scion", "SEAT", "ShuangHuan", "Skoda", "SMA", "Smart", "Soueast", "Spectre", "Spyker",
            "Ssang Yong", "Subaru", "Suzuki", "Talbot", "TATA", "Tatra", "Tazzari", "Tesla", "Tianma", "Tianye",
            "Tofas", "Tonggong", "Toyota", "Trabant", "Triumph", "TVR", "Vauxhall", "Vector", "Venturi", "Vespa",
            "Volkswagen", "Volvo", "Vortex", "VW-Porsche", "Wartburg", "Westfield", "Wiesmann", "Xin Kai", "YueJin",
            "Zastava", "Zorzi", "ZX", "Astro", "VAZ", "GAZ", "ZAZ", "ZIL", "IZH", "KAMAZ", "LUAZ", "Moskvich", "SEAZ",
            "TAGAZ", "UAZ", "Barkas", "BAW", "BMC", "Freightliner", "Golden Dragon", "International", "Intrall",
            "Jinbei", "LDV", "Mudan", "Nisa", "Sokon", "GOLAZ", "RAF", "SEMAR", "ASTRA", "Avia", "Beifan", "CAMC",
            "Hino", "Howo", "IVECO HongYan", "IVECO-Ling Ye", "Iveco-Uralaz", "MAN", "North Benz", "Peterbilt",
            "Pinzgauer", "Robur", "Scania", "Sterling", "Terberg", "Tiema", "Western Star", "YoungMan", "AMUR",
            "БЗКТ", "KAZ", "KRAZ", "MAZ", "MAZ-MAN", "MOAZ", "Ural", "ERF", "Kalmar", "Kenworth", "Mack", "BZKT",
            "MZKT", "Rusich", "ANKAI", "Ayats", "Bova", "Higer", "Ikarbus", "Ikarus", "Irisbus", "Jelcz", "Neoplan",
            "Otokar", "Setra", "TAM", "Temsa", "Thomas Built Buses", "Van Hool", "VDL Bus Chassis", "Yutong",
            "Zhong Tong", "Zonda", "BAZ", "Bogdan", "Volzhanin", "KAVZ", "LAZ", "LIAZ", "MARZ", "NEMAN OZ", "NEFAZ",
            "PAZ", "RMZ", "ROAZ", "ABM", "Aermacchi", "AJP", "AJS", "Alfer", "Amazonas", "American Eagle", "Apollo",
            "Aprilia", "Ardie", "ATK", "Atlant", "Azel", "Bajaj", "BamX", "Benelli", "Beta", "Big Bear Choppers",
            "Big Dog Motorcycles", "Bimota", "Blata", "BM", "BMC Choppers", "Borile", "Boss Hoss", "BSA", "BSE",
            "BucciMoto", "Buell", "Bultaco", "Cagiva", "Campagna", "CCM", "CH Racing", "Chang-Jiang", "Cobra",
            "Confederate", "CPI", "CR&S", "CSR", "CZ", "Daelim", "Dandy", "Defiant", "Derbi", "Dirtmax", "DKW",
            "DM Telai", "Dnepr", "Donghai", "Ducar", "Ducati", "Ecosse", "Factory Bike", "Fantic",
            "Fine Custom Mechanics", "Fischer", "Flyrite Choppers", "Forsage", "Fosti", "Futong", "G&G", "G-max",
            "GAS GAS", "Generic", "Ghezzi-Brian", "GX moto", "Harley-Davidson", "Hartford", "Hercules", "Highland",
            "Honling", "Horex", "Husaberg", "Husqvarna", "Hyosung", "Indian", "IRBIS", "Iron Horse", "Italjet", "Jawa",
            "Jawa-CZ", "Jialing", "Jianshe-Yamaha", "Jincheng", "Johnny Pag", "JRL", "Kangda", "Kanuni", "Kawasaki",
            "Keeway", "Kinlon Motors", "Kramit", "Kreidler", "Kymco", "Laverda", "Legend", "Magni", "Maico", "Malaguti",
            "Malanca", "Matchless", "MBK", "MBS", "Meqelli", "Metrakit", "Midual", "Mikilon", "Minsk", "MM", "Mondial",
            "Montesa", "Moto Guzzi", "Moto Morini", "Motobi", "Motorhispania", "Mototrans", "MTT", "Munch", "MuZ",
            "MV Agusta", "MZ", "NCR", "Neander", "Nexus", "Nipponia", "Norton", "Omaks Motors",
            "Orange County Choppers", "Orion", "OSSA", "Pagsta", "Pannonia", "Patron", "PGO", "Pioneer",
            "Pitmoto", "Pitsterpro", "Polini", "Praga", "PRC", "QingQi", "Qlink", "Rajdoot", "Red Wing",
            "Regal Raptor", "Rhino", "Rieju", "Roehr", "Roxon", "Royal Enfield", "Sachs", "Sagitta", "Sanglas",
            "Saxon", "Scorpa", "Senke", "Sherco", "Siamoto", "Simson", "Skygo", "Solo", "Stels", "SVM", "Swift",
            "Sym", "Tank Sports", "Titan", "TM Racing", "Tomos", "Tomoto", "Travertson", "Troll", "TVS", "UM",
            "Van Veen", "Vento", "Vertemati", "Victory", "Viper", "Von Dutch", "VOR", "Voxan", "Vyrus", "Wakan",
            "Wuyi Wusheng Electric", "Xingfu", "Xispa", "Xmotos", "Yamaha", "Yamasaki", "Yangtze", "Zongshen",
            "Zundapp", "Zweirad-Union", "Voshod", "ZID", "MMZ", "Tula"
    };

    private final String[] menNames = {"Александр", "Максим", "Михаил", "Артём", "Даниил", "Иван", "Дмитрий", "Кирилл",
            "Андрей", "Матвей", "Егор", "Илья", "Марк", "Тимофей", "Роман", "Никита", "Алексей", "Лев", "Владимир",
            "Фёдор", "Ярослав", "Константин", "Сергей", "Степан", "Николай", "Георгий", "Владислав", "Павел", "Арсений",
            "Глеб", "Мирон", "Григорий", "Давид", "Макар", "Денис", "Семён", "Евгений", "Платон", "Савелий", "Артемий",
            "Виктор", "Леонид", "Пётр", "Руслан", "Богдан", "Игорь", "Юрий", "Василий", "Антон", "Захар", "Олег",
            "Демид", "Артур", "Вячеслав", "Елисей", "Всеволод", "Вадим", "Герман", "Святослав", "Филипп", "Дамир",
            "Тихон", "Борис", "Мирослав", "Станислав", "Гордей", "Родион", "Ян", "Серафим", "Валерий", "Демьян",
            "Анатолий", "Яков", "Арсен", "Марат", "Виталий", "Эрик", "Назар", "Альберт", "Мартин", "Ростислав",
            "Игнат", "Аркадий", "Рустам", "Клим", "Яромир", "Добрыня", "Аким", "Эльдар", "Ефим", "Феликс", "Эдуард",
            "Архип", "Булат", "Геннадий", "Гавриил", "Кузьма", "Прохор", "Тимур"
    };

    private final String[] womenNames = {"София", "Мария", "Анна", "Виктория", "Алиса", "Анастасия", "Полина",
            "Александра", "Дарья", "Варвара", "Екатерина", "Ксения", "Арина", "Ева", "Вероника", "Василиса",
            "Милана", "Валерия", "Ульяна", "Кира", "Вера", "Таисия", "Софья", "Маргарита", "Алёна", "Алина",
            "Мирослава", "Кристина", "Диана", "Ольга", "Юлия", "Есения", "Ангелина", "Татьяна", "Стефания",
            "Евгения", "Эмилия", "Яна", "Майя", "Злата", "Ника", "Ирина", "Елена", "Амелия", "Агата", "Аделина",
            "Надежда", "Дарина", "Элина", "Марина", "Ярослава", "Нина", "Светлана", "Милена", "Лидия", "Любовь",
            "Зоя", "Агния", "Наталья", "Олеся", "Антонина", "Карина", "Лилия", "Серафима", "Марьяна", "Каролина",
            "Марианна", "Мира", "Марта", "Раяна", "Аврора", "Владислава", "Мила", "Сабина", "Валентина", "Евдокия",
            "Эмма", "Эвелина", "Евангелина", "Пелагея", "Тамара", "Альбина", "Виолетта", "Лада", "Анфиса", "Анжелика",
            "Алеся", "Юлиана", "Регина", "Алла", "Лия", "Людмила", "Василина", "Влада", "Нелли", "Дария", "Алсу",
            "Виталина", "Дина", "Изабелла", "Луиза", "Марфа", "Катерина", "Снежана", "Ася", "Лина", "Соня",
            "Аида", "Аксинья", "Галина", "Глафира", "Рада", "Элеонора", "Елизавета"
    };

    private final String[] menSurnames = {"Смирнов", "Иванов", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов",
            "Новиков", "Морозов", "Петров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семёнов", "Голубев",
            "Виноградов", "Богданов", "Воробьёв", "Фёдоров", "Михайлов", "Беляев", "Тарасов", "Белов", "Комаров",
            "Орлов", "Киселёв", "Макаров", "Андреев", "Ковалёв", "Ильин", "Гусев", "Титов", "Кузьмин", "Кудрявцев",
            "Баранов", "Куликов", "Алексеев", "Степанов", "Яковлев", "Сорокин", "Сергеев", "Романов", "Захаров",
            "Борисов", "Королёв", "Герасимов", "Пономарёв", "Григорьев", "Лазарев", "Медведев", "Ершов", "Никитин",
            "Соболев", "Рябов", "Поляков", "Цветков", "Данилов", "Жуков", "Фролов", "Журавлёв", "Николаев", "Крылов",
            "Максимов", "Сидоров", "Осипов", "Белоусов", "Федотов", "Дорофеев", "Егоров", "Матвеев", "Бобров",
            "Дмитриев", "Калинин", "Анисимов", "Петухов", "Антонов", "Тимофеев", "Никифоров", "Веселов", "Филиппов",
            "Марков", "Большаков", "Суханов", "Миронов", "Ширяев", "Александров", "Коновалов", "Шестаков", "Казаков",
            "Ефимов", "Денисов", "Громов", "Фомин", "Давыдов", "Мельников", "Щербаков", "Блинов", "Колесников",
            "Карпов", "Афанасьев", "Власов", "Маслов", "Исаков", "Тихонов", "Аксёнов", "Гаврилов", "Родионов",
            "Котов", "Горбунов", "Кудряшов", "Быков", "Зуев", "Третьяков", "Савельев", "Панов", "Рыбаков", "Суворов",
            "Абрамов", "Воронов", "Мухин", "Архипов", "Трофимов", "Мартынов", "Емельянов", "Горшков", "Чернов",
            "Овчинников", "Селезнёв", "Панфилов", "Копылов", "Михеев", "Галкин", "Назаров", "Лобанов", "Лукин",
            "Беляков", "Потапов", "Некрасов", "Хохлов", "Жданов", "Наумов", "Шилов", "Воронцов", "Ермаков", "Дроздов",
            "Игнатьев", "Савин", "Логинов", "Сафонов", "Капустин", "Кириллов", "Моисеев", "Елисеев", "Кошелев",
            "Костин", "Горбачёв", "Орехов", "Ефремов", "Исаев", "Евдокимов", "Калашников", "Кабанов", "Носков",
            "Юдин", "Кулагин", "Лапин", "Прохоров", "Нестеров", "Харитонов", "Агафонов", "Муравьёв", "Ларионов",
            "Федосеев", "Зимин", "Пахомов", "Шубин", "Игнатов", "Филатов", "Крюков", "Рогов", "Кулаков", "Терентьев",
            "Молчанов", "Владимиров", "Артемьев", "Гурьев", "Зиновьев", "Гришин", "Кононов", "Дементьев", "Ситников",
            "Симонов", "Мишин", "Фадеев", "Комиссаров", "Мамонтов", "Носов", "Гуляев", "Шаров", "Устинов", "Вишняков",
            "Евсеев", "Лаврентьев", "Брагин", "Константинов", "Корнилов", "Авдеев", "Зыков", "Бирюков", "Шарапов",
            "Никонов", "Щукин", "Дьячков", "Одинцов", "Сазонов", "Якушев", "Красильников", "Гордеев", "Самойлов",
            "Князев", "Беспалов", "Уваров", "Шашков", "Бобылёв", "Доронин", "Белозёров", "Рожков", "Самсонов",
            "Мясников", "Лихачёв", "Буров", "Сысоев", "Фомичёв", "Русаков", "Стрелков", "Гущин", "Тетерин", "Колобов",
            "Субботин", "Фокин", "Блохин", "Селиверстов", "Пестов", "Кондратьев", "Силин", "Меркушев", "Лыткин", "Туров"
    };
}
