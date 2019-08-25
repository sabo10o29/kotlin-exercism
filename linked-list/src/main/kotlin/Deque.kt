import java.lang.IllegalArgumentException
import kotlin.IllegalStateException

open class Element<T>()
class LinkedElement<T>(var value : T, var next : Element<T>, var previous : Element<T>): Element<T>()
class EmptyElement<T>(): Element<T>()


class Deque<T>(){

    var startElement = EmptyElement<T>() as Element<T>

    private fun getLastElement(): Element<T>{
        var tmp = startElement
        return if(tmp is LinkedElement) getLastElement(tmp) else tmp
    }

    private fun getLastElement(e : LinkedElement<T>): Element<T>{
        var next = e.next
        return  if(next is LinkedElement) getLastElement(next) else e
    }

    /**
     * push (insert value at back);
     */
    fun push(value : T){
        var e = getLastElement()
        if(e is LinkedElement){
            e.next = LinkedElement(value, EmptyElement(), e)
        }else{
            startElement = LinkedElement(value, EmptyElement(), EmptyElement()) as Element<T>
        }
    }

    /**
     * pop (remove value at back);
     */
    fun pop(): T{
        var e = getLastElement()
        if(e is LinkedElement){
            var tmp = e.previous
            if(tmp is LinkedElement){
                tmp.next = EmptyElement()
            }
            return e.value
        }else{
            throw IllegalAccessException("")
        }
    }

    /**
     * shift (remove value at front).
     */
    fun shift(): T{
        var tmp = startElement
        if(tmp is LinkedElement){
            startElement = tmp.next
            return tmp.value
        }else{
            throw IllegalAccessException("")
        }
    }

    /**
     * unshift (insert value at front);
     */
    fun unshift(value : T){
        var tmp = startElement
        if(tmp is LinkedElement){
            tmp.previous = LinkedElement(value, tmp, EmptyElement())
            startElement = tmp.previous
        }else{
            push(value)
        }
    }

}