package com.example.stakanchik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;

    private ArrayList<Integer> images = new ArrayList<>();
    private ArrayList<String> imagesNames = new ArrayList<>();
    private ArrayList<String> imagesShortDescription = new ArrayList<>();
    private ImageButton shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        for(int i = 0; i < 100; i++){
            if(i%6 == 0)
                images.add(R.drawable.pic1);
            else if(i%6 == 1)
                images.add(R.drawable.pic2);
            else if(i%6 == 2)
                images.add(R.drawable.pic3);
            else if(i%6 == 3)
                images.add(R.drawable.pic4);
            else if(i%6 == 4)
                images.add(R.drawable.pic5);
            else if(i%6 == 5)
                images.add(R.drawable.pic6);
        }
        for(int i = 0; i < 100; i++){
            if(i%6 == 0)
                imagesNames.add("Эффект прожектора");
            else if(i%6 == 1)
                imagesNames.add("Мифы об эмоциях");
            else if(i%6 == 2)
                imagesNames.add("Эффект уличного фонаря");
            else if(i%6 == 3)
                imagesNames.add("Удивительные современные гаджеты");
            else if(i%6 == 4)
                imagesNames.add("История венской кофейни");
            else if(i%6 == 5)
                imagesNames.add("Исторические загадки");
        }
        for(int i = 0; i < 100; i++){
            if(i%6 == 0)
                imagesShortDescription.add("Люди склонны преувеличивать то, насколько их внешний вид или действия заметны для окружающих. Поскольку человек большую часть времени сфокусирован на себе самом, ему кажется, что люди вокруг обращают на него куда больше внимания, чем на самом деле.\n" +
                        "\n" +
                        "Термин для описания этого эффекта придумал профессор психологии Корнелльского университета Томас Гилович. В 2000 году он в соавторстве с коллегами опубликовал описания поставленных учеными экспериментов. В ходе одного из них студентов просили надеть майки с изображением певца Барри Манилоу (предварительно уточнив, что абсолютное большинство студентов в реальной жизни ни за что бы их не надели). Затем испытуемые случайно заходили в аудиторию, где сидели студенты-наблюдатели. После эксперимента у испытуемых в майках спрашивали, сколько человек успели заметить их «странный наряд», а затем сравнивали это число с реальным. В результате оказалось, что испытуемые завысили реальный результат в 2 раза: они считали, что футболку заметят 46% человек, на деле же на нее обратили внимание лишь 23%.\n" +
                        "\n" +
                        "Если вам часто кажется, что все вокруг на вас постоянно смотрят, скорее всего, на вас действует эффект прожектора. То же самое относится и ко всем неловким ситуациям из прошлого, за которые вам, может быть, до сих пор стыдно. Не терзайте себя — окружающие, вероятнее всего, уже давно об этом забыли.");
            else if(i%6 == 1)
                imagesShortDescription.add("Все слышали выражение «человек настроения» — таких людей еще называют циклотимиками. Это о личностях с часто меняющимся настроением, переходящим из крайности в крайность. Склонны ли вы поддаваться эмоциям, или умеете контролировать и подавлять их? Стоит ли это делать? Мы решили разобрать самые популярные мифы о природе человеческих эмоций и сопоставить их с реальными фактами.\n" +
                        "\n" +
                        "Миф 1: позитивные эмоции — хорошо, негативные — плохо\n" +
                        "Вполне естественно, что каждый человек старается испытывать больше положительных эмоций, чем отрицательных. Однако полное отсутствие негатива — это утопия. Так человек быстро потеряет вкус к жизни и перестанет ценить то хорошее, что с ним происходит.\n" +
                        "\n" +
                        "Природа задумала человеческую психику таким образом, что каждая конкретная эмоция необходима в конкретный момент. Другой вопрос в том, что периодически одни и те же эмоции могут мешать или помогать. Например, если мы услышали смешную шутку — мы смеемся, и это уместно. Но все мы также знакомы с ситуацией, когда сидим на важном рабочем совещании, и та же самая шутка, рассказанная за пять минут до, снова приходит на ум, вызывая смех — в данном случае это неуместно. То же самое касается и негатива. Скажем, в повседневной жизни страх причиняет нам больше неудобств, чем приносит пользы. Однако в какие-то критические моменты он может помочь и даже спасти жизнь — так случилось несколько лет назад с парашютисткой. Когда стропы ее парашюта запутались, хрупкая девушка без выдающихся физических способностей разорвала их самостоятельно из-за страха смерти.\n" +
                        "\n" +
                        "Следовательно, делить эмоции на плохие и хорошие — бессмысленно, так как все они нужны.\n" +
                        "\n" +
                        "Миф 2: человек не может контролировать свои эмоции\n" +
                        "А вот и нет — каждому под силу заняться самодисциплиной и воспитывать в себе определенные качества, которые будут помогать в управлении эмоциями. Этому поспособствует изменение образа мышления и поведения, а также умение периодически задавать себе вопрос, как бы поступила ваша лучшая версия, и насколько это решение было бы оправданным.\n" +
                        "\n" +
                        "Миф 3: управление эмоциями = роботорежим\n" +
                        "Многие зачастую путают подавление эмоций с их контролем, а это принципиально разные вещи. Эмоционально зрелый, психологически здоровый человек позволяет себе жить с полным спектром эмоций, но не идет у них на поводу.\n" +
                        "\n" +
                        "Миф 4: мне нельзя чувствовать то, что я чувствую\n" +
                        "Порой бывают в жизни такие ситуации, когда вам кажется, что какая-то ваша реакция на происходящее неправильная, неуместная не столько с точки зрения этики, сколько со стороны морали. На похоронах родственников среди, казалось бы, убивающихся горем друзей и близких вам думается, что вы недостаточно скорбите, и это как-то некрасиво с вашей стороны и вообще фу? Да плевать — вы человек и имеете право на любую эмоцию в любой момент жизни, хотя порой из-за сильных впечатлений мозг «неправильно» трактует ситуацию и выдает спектр самых неожиданных реакций.\n" +
                        "\n" +
                        "Миф 5: на мои эмоции влияет только мое окружение\n" +
                        "Не-а — хозяином ситуации всегда являетесь вы. Поведение людей вокруг может быть вдохновляющим, пугающим, агрессивным, но как на него реагировать, решаете в конечном итоге только вы. Например, при общении с неприятным человеком, который периодически провоцирует вас, именно вы в первую очередь принимаете ряд решений — поддаться ли на эту провокацию и продолжать ли в дальнейшем общение с собеседником в принципе.\n" +
                        "\n" +
                        "Подытоживая все вышесказанное, можно сделать вывод, что для эмоционального здоровья необходимы прежде всего правильный подход и осознание ответственности за свои мысли и чувства. Не стоит ругать себя за то, что вы испытываете — это же ваше, внутреннее, настоящее. Мало уметь прислушиваться к себе — нужна еще хорошая самодисциплина, чтобы не идти на поводу у эмоций. Попробуйте иногда проявлять к самому себе сострадание и избегать оценочных суждений.");
            else if(i%6 == 2)
                imagesShortDescription.add("Эффект уличного фонаря — это желание искать решение проблемы там, где его легче всего найти.\n" +
                        "\n" +
                        "Парадоксально, но уличные фонари являются отличной метафорой не только для описания научных лже-феноменов, но и порой для описания науки в целом. Эффектом уличного фонаря называют неверный вывод в научных исследованиях, поведший науку по неверному, но наипростейшему пути, что в итоге стоит людям денег, времени, а иногда и жизни.\n" +
                        "\n" +
                        "Название «эффект уличного фонаря» пришло из анекдота: сотрудник полиции патрулирует улицы ночью и видит ползающего под фонарём неопрятного парня, от которого разит перегаром. Полицейский подходит к нему и спрашивает, в чём проблема, на что парень отвечает, что уронил ключи от своей машины и теперь не может их найти. Коп оглядывает освещённый участок улицы, никаких ключей не видит, спрашивает у пьяного, где именно тот их уронил, и парень указывает пальцем на другую сторону улицы, где царит темнота. Тогда полицейский удивляется, почему он ищет ключи здесь, если уронил в другом месте, на что парень «логично» отвечает: «А тут светлее».\n" +
                        "\n" +
                        "Ради справедливости стоит заметить, что этот парень точно знал, что ключи всё-таки где-то есть. У учёных нет возможности узнать, лежат ли ответы на определённые научные вопросы в какой-то конкретной области исследований. Так что в науке существует заметная тенденция — сначала проверяют ту гипотезу, где, казалось бы, получить ответ на поставленный вопрос проще всего, даже если есть весомые аргументы, говорящие, что полученный вывод будет ошибочным.\n" +
                        "\n" +
                        "Это не такой уж плохой подход. Иногда попытка воспользоваться той минимальной информацией, что уже есть в наличии, вместо того, чтобы бродить вокруг предполагаемого «источника света» в полной темноте, может на неопределённое время помочь науке объяснить что то, но если через некоторое время теория ничем не подтверждается, то могут возникнуть огромные проблемы.\n" +
                        "\n" +
                        "Приведём пример. Существует препарат, стабилизирующий сердцебиение после сердечного приступа. Нетрудно догадаться, что препарат имел большой успех: врачам давно известно, что пациенты с учащённым сердцебиением больше подвержены риску смерти, чем те, у которых ритм в норме. Препарат делал только то, что должен был делать — замедлял сердцебиение, и помогал настолько хорошо, что прошло десять лет, прежде чем врачи заметили, что те люди, которые его принимали, оставались в живых в три раза реже, чем те, кто его не принимал.\n" +
                        "\n" +
                        "Ритм сердца одного пациента измерить легко. А вот общего коэффициента смертности для всех пациентов не было, он появился позже, когда закрывать глаза на «совпадения» стало невозможно. Это объясняет, почему простые меры предлагаются знатоками в качестве панацеи, но потом быстро доказывают свою несостоятельность. Те меры были простыми и следовательно, очевидными, вследствие чего на долгое время закрыли для исследователей другие пути решения проблемы.\n" +
                        "\n" +
                        "Все мы иногда позволяем мечтам идти перед логикой, надеясь, что найдём лучшее решение там, где проще всего искать. В большинстве случаев это не имеет серьёзных последствий. Однако иногда истина и лёгкость не могут идти рука об руку.");
            else if(i%6 == 3)
                imagesShortDescription.add("Каждый год на выставке CES, проходящей в Лас-Вегасе, крупные компании презентуют современную технику. Некоторые из выставляемых гаджетов получают большую популярность, другие настолько странные, что вызывают удивление у публики. В 2019 году было представлено много интересных новинок.\n" +
                        "\n" +
                        "Телевизоры и смартфоны с гибким экраном\n" +
                        "\n" +
                        "Для тех, кто следит за новостями в сфере современных технологий, такие гаджеты не станут великим открытием, но для обычных людей гнущиеся дисплеи — настоящее откровение. Сразу несколько технокомпаний представили гибкие телефоны: Samsung, Huawei, Royole. Другие производители также занимаются разработкой подобных девайсов. На выставке был показан рулонный телевизор от компании LG. Он выполнен в виде тумбочки, из которой выдвигается дисплей. Когда его нужно убрать, специальный механизм сворачивает его в рулон, который прячется в тумбочку. При этом экран разворачивается как полностью, так и частично.\n" +
                        "\n" +
                        "Автомобиль, который ходит\n" +
                        "\n" +
                        "Hyundai несколько лет занимается разработкой автомобиля-робота, имеющего четыре конечности. Такая машина призвана помогать людям во время бедствий, поскольку она умеет взбираться по камням и расчищать завалы. Этот гибрид получил название Elevate. Его ноги-колеса могут поворачиваться на 360° по вертикальной оси. На обычной дороге машина будет ехать на колесах как любой другой автомобиль, но в экстремальных ситуациях колеса выдвигаются и превращаются в ноги, которые легко перешагивают через препятствия. \n" +
                        "\n" +
                        "Роботы, доставляющие товар\n" +
                        "\n" +
                        "Компания Continental представила беспилотный автомобиль, на котором удастся доставлять товар людям. Вместо обычных доставщиков работать будут роботы. Как будут выглядеть последние, еще неизвестно. Разработчики сомневаются, оставить ли стандартный форм-фактор или отдать предпочтение роботам в виде собак. \n" +
                        "\n" +
                        "Аэротакси\n" +
                        "\n" +
                        "Партнер Uber — компания Bell, специализирующаяся на производстве вертолетов — анонсировала аэротакси Nexus. Пятиместный летательный аппарат на электротяге будет доступен уже через 5 лет. Планируется, что он будет развивать скорость до 240 км/ч. Пока был показан лишь прототип аэротакси, но Bell придется поскорее создать рабочую модель, ведь не только они работают над внедрением подобного транспорта.\n" +
                        "\n" +
                        "Умная гиря\n" +
                        "\n" +
                        "Находку для всех спортсменов придумали в Jaxjox. Гиря изменяет свой вес (от 5,5 до 19 кг), поэтому она одна заменит массу спортивного инвентаря. Устройство оснащено экраном для вывода информации, синхронизируется с приложением для отслеживания данных о тренировке. Стоимость такого девайса будет достигать порядка 350 долларов.\n" +
                        "\n" +
                        "Модульный телевизор\n" +
                        "\n" +
                        "Samsung удивила посетителей выставки, представив модульный телевизор. Квадратные блоки, которые практически не имеют рамок, позволяют сделать устройство удобных размера и формы. \n" +
                        "\n" +
                        "Подводная лодка в форме акулы\n" +
                        "\n" +
                        "Innespace Seabreacher — гибрид подводной лодки и катера, выполненный в виде акулы. Она может погружаться под воду на глубину 3,5 метра и выныривать оттуда весьма эффектным способом, наподобие дельфина. Подводная лодка умеет проделывать и другие трюки, которые выполняют эти млекопитающие, например, крутиться вокруг себя. Innespace Seabreacher развивает скорость до 80 км/ч над водой, а под водой — до 40 км/ч.\n" +
                        "\n" +
                        "Клавиатура будущего\n" +
                        "\n" +
                        "Nemeio разработали необычную беспроводную клавиатуру с E-Ink дисплеем, заменившим привычные механические клавиши. Всего в ее составе 81 функциональная клавиша. Внешний вид клавиш можно настраивать. Они постоянно подсвечиваются, что делает гаджет удобным для использования в ночное время. Пользовательские настройки сохраняются в памяти клавиатуры.\n" +
                        "\n" +
                        "Налобный трекер сна\n" +
                        "\n" +
                        "Трекеры сна встраивают в умные часы и пояса, но компания Beddr пошла еще дальше и придумала налобный трекер. Устройство компактное, но пока не ясно, насколько удобно будет спать с приклеенным на лоб трекером. Тем не менее, производитель обещает максимально точные данные о фазах сна, частоте сердечных сокращений, положении тела, уровне насыщения крови кислородом.\n" +
                        "\n" +
                        "Устройство для складывания вещей");
            else if(i%6 == 4)
                imagesShortDescription.add("Хотя термин «венские кофейни» известен по всему миру, Вена была далеко не первым городом, где появились такого рода заведения. Всё началось ещё в XII веке — с Мекки, Саудовская Аравия. Первая же европейская кофейня появилась в Венеции — в 1647 году. В Англии кофейни стали открываться в 1650-е годы. И лишь в 1683 году появилась первая кофейня в городе Вена. И несмотря на то, что первооткрывателем было другое государство, венские кофейни заложили крепкий фундамент изящным кофейным традициям, которых нет ни в одном другом городе мира. Самый лучший кофе подают в Вене!\n" +
                        "\n" +
                        "История венской кофейной культуры тесно связана с окончанием Венской битвы в 1683 году. Легенда гласит, что в результате битвы польско-австро-германские войска нанесли сокрушительное поражение турецкой армии, а австрийский военнослужащий Георг Франц Кольшицкий (1640-1694) в награду за свои героические поступки получил право взять себе часть захваченного трофейного имущества, и он выбрал… 300 мешков кофе. С того дня началась его миссия — «научить Европу пить кофе». Но любимый турками напиток поначалу не понравился венцам, и Кольшицкий стал подслащивать кофе мёдом, а также добавлять в него молоко. Отсюда и пошёл рецепт всеми известного «кофе по-венски». Кстати говоря, Кольшицкому приписывают изобретение круассана — «турецкого полумесяца».\n" +
                        "\n" +
                        "Однако, несмотря на грандиозное внедрение кофе Кольшицким, первая кофейня в Вене была основана армянским купцом и разведчиком из Константинополя Диодато Йоханнесом (1640-1725). Благодаря ему союзники Священной Римской империи достигли Вены, и в 1683 году объединённые христианские армии смогли нанести сокрушительное поражение Османской империи. В знак благодарности император Священной Римской империи Леопольд I даровал Йоханнесу монопольное право продавать кофе в течение 20 лет. О самом искусстве приготовления и подачи кофе Йоханнес узнал у себя на родине.\n" +
                        "\n" +
                        "В 1720 году в центре Вены появилась кофейня под названием Kramersches Kaffeehaus, где для посетителей вместе с чашечкой кофе и стаканом воды подавали свежую газету. Это был ещё один серьёзный шаг в истории венской кофейной культуры, когда впервые было разрешено подавать еду и алкоголь. Тем не менее, континентальная блокада Англии французским императором Наполеоном I в 1808 году плохо отразилась и на Австрии — резко возросли цены на кофе. Владельцам кофеен необходимо было отыскать альтернативы, чтобы не обанкротиться. Сие привело к развитию в Вене кафе-ресторанов.\n" +
                        "\n" +
                        "После Венского конгресса в 1814-1815 годах венская кофейная культура вновь расцвела. В этот период кофе становится олицетворением высокого качества европейской жизни. Кофейни по-венски открывались в Праге, Загребе, Вероне, Триесте и Венеции. Огромные помещения, кресла из красного бархата и величественные люстры были характерными чертами для престижных «кофейных комнат». Также в 1856 году женщинам разрешили посещать такие места, потому что до этого в кофейнях женщинами были только кассирши.");
            else if(i%6 == 5)
                imagesShortDescription.add("Кажется, это одно из фундаментальных правил, которые нам нужно усвоить: невозможно знать всё. Немало тайн хранит в себе история. Некоторые из них стары как мир, другие — относительно молоды.\n" +
                        "\n" +
                        "Загадка богатств Гитлера\n" +
                        "\n" +
                        "Список сокровищ, принадлежавших Адольфу Гитлеру, поражает воображение. Оценочная стоимость запаса награбленных золотых слитков, иностранных банкнот и ювелирных изделий достигает 4 миллиардов долларов. Но тайник, в котором хранились эти богатства, опустел вскоре после поражения Германии во Второй мировой войне. В последующие десятилетия отдельные вещи из этой коллекции обнаруживали во многих странах — Португалии, Турции, Испании, Швейцарии и даже Швеции.\n" +
                        "Сотни авантюристов до сих пор продолжают охотиться за этими сокровищами, но даже через 70 лет никто не знает, куда исчезло всё золото Адольфа Гитлера.\n" +
                        "Некоторые считают, что Гитлер ещё в последние месяцы войны перепрятал богатства в Дойчнойдорфе (немецкой коммуне на земле Саксонии). Другие люди уверены, что сокровища покоятся на дне австрийского озера Топлиц. А кто-то убеждён, что они хранятся раздельно в десятках банков по всему миру…\n" +
                        "\n" +
                        "Исчезновение судна «Циклоп»\n" +
                        "\n" +
                        "Бермудский треугольник известен как место, где происходят загадочные исчезновения кораблей и самолётов. Многим из них учёные не могут дать каких-то логических объяснений. В частности, это относится к американскому кораблю «Циклоп», построенному незадолго до начала Первой мировой войны.\n" +
                        "В начале февраля 1918 года «Циклоп» взял курс на Бразилию, планируя снабдить топливом британские корабли, бороздящие просторы Южной Атлантики. На обратном пути судно сделало внеплановую остановку возле острова Барбадос, после чего направилось в Балтимор. Произошло это 4 марта 1918 года. С этого дня «Циклоп» больше никто не видел. На борту судна находилось более 300 пассажиров и несколько десятков членов экипажа. Все они считаются пропавшими без вести.\n" +
                        "Американское правительство потратило на тщательные поиски «Циклопа» почти 10 лет, но никаких следов судна обнаружить не удалось.\n" +
                        "\n" +
                        "Местонахождение останков Колумба — исторический спор\n" +
                        "\n" +
                        "Великого исследователя первоначально похоронили в испанском Вальядолиде. Через несколько десятилетий его останки были перенесены на остров Эспаньола (Карибское море), как он и завещал. Но когда в 1875 году остров перешёл во владение французов, испанцам перевезли останки Колумба на Кубу. Там они покоились до 1898 года (Испано-американской войны). А затем вернулись в Испанию, в Севилью.\n" +
                        "В 2006 году останки подвергли генетической экспертизе и сравнительному анализу, которые доказали их подлинность. Но не тут-то было! Власти Доминиканской Республики отказались признавать результаты этой ДНК-экспертизы. Они по-прежнему пытаются доказать, что останки Колумба захоронены именно в их стране.\n" +
                        "Забавно, но в 1877 году в одном из перуанских (!) соборов был найден обветшалый ящик с надписью, что в нём находятся останки «прославленного Христофора Колумба».\n" +
                        "\n" +
                        "Неразгаданная тайна Фестского диска\n" +
                        "\n" +
                        "Минойская цивилизация считается большинством историков «начальным звеном в цепи европейских народов». Фестский диск, обнаруженный в 1908 году археологом Луиджи Пернье в небольшом городке Фесте (остров Крит), подарил учёным надежду, что они смогут узнать об этой развитой цивилизации немного больше.\n" +
                        "Но Фестский диск упорно не желает раскрывать свои тайны. Содержимое диска до сих пор остаётся неразгаданным. Кто-то считает, что на нём записан гимн или молитва, кто-то уверен, что это календарь. К сожалению, научное сообщество не имеет возможности подтвердить или опровергнуть эти гипотезы.");
        }

        adapter = new Adapter(images, imagesNames, imagesShortDescription, shareButton,this);
        recyclerView.setAdapter(adapter);
    }
}