package Observer;

/**
 * @author zhp
 * @date 2022-08-22 20:36
 */

/**观察者
 *
 * 观察者模式：对象之间多对一依赖的一种设计方案，被依赖的对象为 Subject，依赖的对象为 Observer，Subject
 * 通知 Observer 变化,比如这里的奶站是 Subject，是 1 的一方。用户时 Observer，是多的一方
 *
 * 观察者模式的好处
 * 1) 观察者模式设计后，会以集合的方式来管理用户(Observer)，包括注册，移除和通知。
 * 2) 这样，我们增加观察者(这里可以理解成一个新的公告板)，就不需要去修改核心类 WeatherData 不会修改代码，
 * 遵守了 ocp 原则
 */
public class Observer {
}
